package dhbw.tam.logisim.gates;

import dhbw.tam.logisim.LogicGate;

import java.util.stream.Stream;

public final class SimpleGate implements LogicGate {
    private final LogicGate left;
    private final LogicGate right;
    private final String label;
    private final DetermineOutput determineOutput;

    private SimpleGate(LogicGate left, LogicGate right, String label, DetermineOutput determineOutput) {
        this.left = left;
        this.right = right;
        this.label = label;
        this.determineOutput = determineOutput;
    }

    public static SimpleGate and(LogicGate left, LogicGate right) {
        return new SimpleGate(left, right, "AND", (l, r) -> l && r);
    }

    public static SimpleGate or(LogicGate left, LogicGate right) {
        return new SimpleGate(left, right, "OR", (l, r) -> l || r);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Stream<LogicGate> getInputs() {
        return Stream.of(left, right);
    }

    @Override
    public boolean getValue() {
        return determineOutput.determineOutput(left.getValue(), right.getValue());
    }

    interface DetermineOutput {
        boolean determineOutput(boolean left, boolean right);
    }

    @Override
    public String toString() {
        return "SimpleGate{" +
                "label='" + label + "'" +
                '}';
    }
}
