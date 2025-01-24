package dhbw.tam.pollutionmap;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int resolution = 20;

        HeatMap map = new HeatMap(resolution);

        for (int x = 0; x < resolution; x++) {
            for (int y = 0; y < resolution; y++) {
                float longitude = (float) (360.0 / resolution * x);
                float latitude = (float) (360.0 / resolution * y);

                map.setValueAt(
                        latitude,
                        longitude,
                        // My understanding of latitude and longitude was completely incorrect,
                        // so we do some hacky semi-functional conversion
                        0.05F * PollutionApi.getPM25(
                                (latitude - 180) / 2F,
                                longitude - 180
                        )
                );
            }
        }

        map.exportPng("heatmap");
        map.asBlurred().exportPng("heatmap-blurred");
    }
}