package dhbw.tam.conditions;

import java.util.Random;

public class GradeCalculator {
    public static void main(String[] args) {
        Random rng = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int score = rng.nextInt(1, 101);
            String grade = getGradeForScore(score);
            System.out.println("Score: " + score + " Grade:" + grade);
        }
    }

    static String getGradeForScore(int score) {
        assert score <= 100 : "Score is more than 100";
        return switch (score / 10) {
            case 10 -> "A";
            case 9 -> "B";
            case 8 -> "C";
            case 7 -> "D";
            case 6 -> "E";
            default -> "F";
        };
    }
}
