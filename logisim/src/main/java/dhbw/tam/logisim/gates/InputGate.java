package dhbw.tam.logisim.gates;

import dhbw.tam.logisim.LogicGate;

import java.util.stream.Stream;

public class InputGate implements LogicGate {
    private final char id;
    private boolean currentValue;

    public InputGate(char id, boolean defaultValue) {
        this.id = id;
        this.currentValue = defaultValue;
    }

    public char getId() {
        return id;
    }

    public void toggle() {
        currentValue = !currentValue;
    }

    @Override
    public String getLabel() {
        return getValue() ? id + "  TRUE" : id + " FALSE";
    }

    @Override
    public Stream<LogicGate> getInputs() {
        return Stream.empty();
    }

    @Override
    public boolean getValue() {
        return currentValue;
    }

    @Override
    public String toString() {
        return "InputGate{" +
                "currentValue=" + currentValue +
                '}';
    }
}
