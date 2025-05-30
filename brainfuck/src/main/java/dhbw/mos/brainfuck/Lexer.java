package dhbw.mos.brainfuck;
import java.util.List;
import java.util.ArrayList;
public class Lexer {

    public static List<Token> lex(String inputText) throws IllegalArgumentException {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.charAt(i);
            if (Character.isWhitespace(ch)) continue;

            switch (ch) {
                case '+':
                    tokens.add(Token.INCREMENT);
                    break;
                case '-':
                    tokens.add(Token.DECREMENT);
                    break;
                case '<':
                    tokens.add(Token.LEFT);
                    break;
                case '>':
                    tokens.add(Token.RIGHT);
                    break;
                case ',':
                    tokens.add(Token.INPUT);
                    break;
                case '.':
                    tokens.add(Token.OUTPUT);
                    break;
                case '[':
                    tokens.add(Token.LOOP_OPEN);
                    break;
                case ']':
                    tokens.add(Token.LOOP_CLOSE);
                    break;
                case 'x':
                    tokens.add(Token.BREAKPOINT);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid character '" + ch + "' at position " + i);
            }
        }

        return tokens;
    }

}
