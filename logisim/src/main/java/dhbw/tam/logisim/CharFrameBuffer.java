package dhbw.tam.logisim;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CharFrameBuffer {
    private static final char EMPTY = ' ';

    List<List<Optional<Character>>> rows;

    public CharFrameBuffer() {
        this.rows = new ArrayList<>();
    }

    public Size2i getBoundingBox() {
        int height = rows.size();
        int width = rows.stream().map(List::size).max(Integer::compareTo).orElse(0);
        return new Size2i(width, height);
    }

    public Optional<Character> getOptional(int x, int y) {
        if (y < rows.size()) {
            List<Optional<Character>> row = rows.get(y);
            if (x < row.size()) {
                return row.get(x);
            }
        }
        return Optional.empty();
    }

    public char get(int x, int y) {
        return getOptional(x, y).orElse(EMPTY);
    }

    public void set(int x, int y, char value) {
        while (rows.size() <= y) rows.add(new ArrayList<>());
        List<Optional<Character>> row = rows.get(y);
        while (row.size() <= x) row.add(Optional.empty());
        row.set(x, Optional.of(value));
    }

    public void copyAtPosition(CharFrameBuffer other, Point2i position) {
        Size2i otherBoundingBox = other.getBoundingBox();
        for (int otherX = 0; otherX < otherBoundingBox.width(); otherX++) {
            for (int otherY = 0; otherY < otherBoundingBox.height(); otherY++) {
                int thisX = otherX + position.x();
                int thisY = otherY + position.y();
                other.getOptional(otherX, otherY).ifPresent(c -> this.set(thisX, thisY, c));
            }
        }
    }

    public String asString() {
        StringBuilder result = new StringBuilder();

        for (List<Optional<Character>> row : rows) {
            for (Optional<Character> character : row) {
                result.append(character.orElse(EMPTY));
            }
            result.append("\n");
        }

        return result.toString();
    }
}
