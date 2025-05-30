package dhbw.mos.brainfuck;

import dhbw.mos.brainfuck.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;

public class Parser {
    public static Command parse(List<Token> tokens) {
        Stack<CommandSequence> sequenceStack = new Stack<>();
        sequenceStack.push(new CommandSequence(new ArrayList<>()));

        Supplier<List<Command>> currentSequence = () -> sequenceStack.peek().commands();

        for (Token token : tokens) {
            switch (token) {
                case INCREMENT -> {
                    currentSequence.get().add(new ChangeValue(true));
                }
                case DECREMENT -> {
                    currentSequence.get().add(new ChangeValue(false));
                }
                case LEFT -> {
                    currentSequence.get().add(new MovePointer(false));
                }
                case RIGHT -> {
                    currentSequence.get().add(new MovePointer(true));
                }
                case INPUT -> {
                    currentSequence.get().add(new Input());
                }
                case OUTPUT -> {
                    currentSequence.get().add(new Output());
                }
                case BREAKPOINT -> {
                    currentSequence.get().add(new Breakpoint());
                }
                case LOOP_OPEN -> {
                    CommandSequence newSequence = new CommandSequence(new ArrayList<>());
                    currentSequence.get().add(new Loop(newSequence));
                    sequenceStack.push(newSequence);
                }
                case LOOP_CLOSE -> {
                    sequenceStack.pop();
                }
            }
        }

        return sequenceStack.peek();
    }
}
