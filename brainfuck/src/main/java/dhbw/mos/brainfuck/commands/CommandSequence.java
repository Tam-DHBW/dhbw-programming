package dhbw.mos.brainfuck.commands;

import dhbw.mos.brainfuck.Command;
import dhbw.mos.brainfuck.State;

import java.util.List;

public record CommandSequence(List<Command> commands) implements Command {
    @Override
    public void performAction(State state) {
        for (Command command : this.commands) {
            command.performAction(state);
        }
    }
}
