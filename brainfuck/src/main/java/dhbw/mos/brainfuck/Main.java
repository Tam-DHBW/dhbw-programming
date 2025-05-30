package dhbw.mos.brainfuck;

public class Main {
    public static void main(String[] args) {
        // Read a string followed by the terminator `=` and then output it
        String program = """
                >
                +
                [
                    [-]
                    >>,[<+<+>>-]
                    <
                    -------------------------------------------------------------
                ]
                x
                <[-]<
                [<]>
                [.>]
                """;

        var tokens = Lexer.lex(program);
        System.out.println("Token list (" + tokens.size() + "): " + tokens);

        var command = Parser.parse(tokens);
        System.out.println("Command: " + command);

        command.performAction(new State());
    }
}