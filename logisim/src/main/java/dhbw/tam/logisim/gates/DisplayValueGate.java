package dhbw.tam.logisim.gates;

import dhbw.tam.logisim.LogicGate;

import java.util.stream.Stream;

public class DisplayValueGate implements LogicGate {
    private final LogicGate input;

    public DisplayValueGate(LogicGate input) {
        this.input = input;
    }

    @Override
    public String getLabel() {
        return getValue() ? "=>  TRUE" : "=> FALSE";
    }

    @Override
    public Stream<LogicGate> getInputs() {
        return Stream.of(input);
    }

    @Override
    public boolean getValue() {
        return input.getValue();
    }
}
