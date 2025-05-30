package dhbw.mos.brainfuck.commands;

import dhbw.mos.brainfuck.Command;
import dhbw.mos.brainfuck.State;

public record Loop(Command command) implements Command {
    @Override
    public void performAction(State state) {
        while (state.getMemory()[state.getPointer()] != 0) {
            command.performAction(state);
        }
    }
}
