package dhbw.tam.logisim;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CircuitUI {
    static RenderResult render(LogicGate gate) {
        List<RenderResult> inputRenders = gate.getInputs().map(CircuitUI::render).toList();

        CharFrameBuffer thisBuffer = new CharFrameBuffer();

        String label = " " + gate.getLabel() + " ";
        int width = label.length() + 2;
        int height = (int) Math.max(gate.getInputs().count(), 1) * 2 + 1;
        int centerY = height / 2;

        thisBuffer.set(0, 0, '╔');
        thisBuffer.set(width - 1, 0, '╗');
        thisBuffer.set(width - 1, height - 1, '╝');
        thisBuffer.set(0, height - 1, '╚');
        IntStream.range(1, width - 1).forEach(x -> thisBuffer.set(x, 0, '═'));
        IntStream.range(1, width - 1).forEach(x -> thisBuffer.set(x, height - 1, '═'));
        IntStream.range(1, height - 1).forEach(y -> thisBuffer.set(0, y, '║'));
        IntStream.range(1, height - 1).forEach(y -> thisBuffer.set(width - 1, y, '║'));

        IntStream.range(0, label.length()).forEach(idx -> thisBuffer.set(1 + idx, centerY, label.charAt(idx)));

        CharFrameBuffer compositingBuffer = new CharFrameBuffer();

        int inputRenderHeight = 0;
        int inputRenderWidth = 0;
        List<Point2i> inputOutputLocations = new ArrayList<>();
        for (RenderResult inputRender : inputRenders) {
            compositingBuffer.copyAtPosition(inputRender.buffer(), new Point2i(0, inputRenderHeight));

            inputOutputLocations.add(new Point2i(
                    inputRender.outputLocation().x(),
                    inputRender.outputLocation().y() + inputRenderHeight
            ));

            Size2i boundingBox = inputRender.buffer().getBoundingBox();
            inputRenderHeight += boundingBox.height() + 1;
            inputRenderWidth = Math.max(inputRenderWidth, boundingBox.width());
        }

        int horizontalSpace = 0;
        if (!inputOutputLocations.isEmpty()) {
            horizontalSpace = 3 + ((inputOutputLocations.size() - 1) / 2) * 2;
        }

        Point2i thisCompositingPosition = new Point2i(inputRenderWidth + horizontalSpace, Math.max(inputRenderHeight - height, 0) / 2);
        compositingBuffer.copyAtPosition(thisBuffer, thisCompositingPosition);

        for (int inputIndex = 0; inputIndex < inputOutputLocations.size(); inputIndex++) {
            Point2i inputOutputLocation = inputOutputLocations.get(inputIndex);
            Point2i thisInputLocation = new Point2i(thisCompositingPosition.x() - 1, thisCompositingPosition.y() + 1 + (2 * inputIndex));

            int verticalWireX = thisInputLocation.x() - 1;

            for (int x = inputOutputLocation.x(); x <= verticalWireX; x++) {
                compositingBuffer.set(x, inputOutputLocation.y(), '-');
            }
            for (int x = verticalWireX; x <= thisInputLocation.x(); x++) {
                compositingBuffer.set(x, thisInputLocation.y(), '-');
            }

            int outputY = inputOutputLocation.y();
            int inputY = thisInputLocation.y();
            if (outputY != inputY) {
                for (int y = Math.min(outputY, inputY); y <= Math.max(outputY, inputY); y++) {
                    compositingBuffer.set(verticalWireX, y, '|');
                }
            }
        }

        return new RenderResult(compositingBuffer, new Point2i(thisCompositingPosition.x() + width, thisCompositingPosition.y() + centerY));
    }

    public record RenderResult(CharFrameBuffer buffer, Point2i outputLocation) {
    }
}
