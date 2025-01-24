package dhbw.tam.pollutionmap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HeatMap {
    private final int resolution;
    private final List<Float>[][] map;

    public HeatMap(int resolution) {
        this.resolution = resolution;
        this.map = new List[resolution][resolution];

        for (int x = 0; x < resolution; x++) {
            for (int y = 0; y < resolution; y++) {
                this.map[y][x] = new ArrayList<>();
            }
        }
    }

    public void setValueAt(float latitude, float longitude, float value) {
        int y = (int) (latitude / 360.0 * resolution);
        int x = (int) (longitude / 360.0 * resolution);

        this.map[y % resolution][x % resolution].add(value);
    }

    public HeatMap asBlurred() {
        HeatMap blurred = new HeatMap(resolution);

        int blurSize = (int) ((double) resolution * 0.1);

        for (int x = 0; x < resolution; x++) {
            for (int y = 0; y < resolution; y++) {
                List<Float> values = new ArrayList<>();

                for (int rectXOffset = -blurSize; rectXOffset <= blurSize; rectXOffset++) {
                    for (int rectYOffset = -blurSize; rectYOffset <= blurSize; rectYOffset++) {
                        int weight = 2 * resolution - (Math.abs(rectXOffset) + Math.abs(rectYOffset));

                        int rectX = Math.floorMod(x + rectXOffset, resolution);
                        int rectY = y + rectYOffset;

                        // Wrapping around from the North Pole to the South Pole does not make any sense
                        if (rectY < 0 || rectY >= resolution) continue;

                        float value = average(this.map[rectY][rectX]);

                        IntStream.range(0, weight).forEach(i -> values.add(value));
                    }
                }

                float average = average(values);
                blurred.map[y][x].add(average);
            }
        }

        return blurred;
    }

    public void exportPng(String filename) {
        BufferedImage image = new BufferedImage(resolution, resolution, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < resolution; x++) {
            for (int y = 0; y < resolution; y++) {
                double average = average(this.map[y][x]);

                Color color = new Color(Math.min((int) (average * 255), 255), 0, 0);
                image.setRGB(x, y, color.getRGB());
            }
        }

        try {
            ImageIO.write(image, "png", new FileOutputStream(Path.of(filename + ".png").toFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static float average(List<Float> list) {
        return (float) list.stream()
                .mapToDouble(Float::doubleValue)
                .average()
                .orElse(0.0);
    }
}
