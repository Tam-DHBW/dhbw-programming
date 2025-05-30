package dhbw.mos.brainfuck.commands;

import dhbw.mos.brainfuck.Command;
import dhbw.mos.brainfuck.State;

public class Output implements Command {
    @Override
    public void performAction(State state) {
        System.out.print((char) state.getMemory()[state.getPointer()]);
        System.out.flush();
    }
}
