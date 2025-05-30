package dhbw.mos.brainfuck.commands;

import dhbw.mos.brainfuck.Command;
import dhbw.mos.brainfuck.State;

import java.io.IOException;
import java.util.Scanner;

public class Input implements Command {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void performAction(State state) {
        char input;
        try {
            while ((input = (char) System.in.read()) == '\n') {
            }
            state.getMemory()[state.getPointer()] = input;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
