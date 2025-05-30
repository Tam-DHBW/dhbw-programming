package dhbw.mos.brainfuck.commands;

import dhbw.mos.brainfuck.Command;
import dhbw.mos.brainfuck.State;

public class Breakpoint implements Command {
    @Override
    public void performAction(State state) {
        int noop = 123; // Set breakpoint here
    }
}
