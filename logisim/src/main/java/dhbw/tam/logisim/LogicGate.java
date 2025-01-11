package dhbw.tam.logisim;

import dhbw.tam.logisim.gates.DisplayValueGate;

import java.util.stream.Stream;

public interface LogicGate {
    String getLabel();

    Stream<LogicGate> getInputs();

    boolean getValue();

    default DisplayValueGate display() {
        return new DisplayValueGate(this);
    }
}
