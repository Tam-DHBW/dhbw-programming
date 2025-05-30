package dhbw.mos.brainfuck.commands;

import dhbw.mos.brainfuck.Command;
import dhbw.mos.brainfuck.State;

public record ChangeValue(boolean increment) implements Command {
    @Override
    public void performAction(State state) {
        int changeBy = this.increment ? 1 : -1;
        state.getMemory()[state.getPointer()] += changeBy;
        state.getMemory()[state.getPointer()] %= 256;
    }
}
