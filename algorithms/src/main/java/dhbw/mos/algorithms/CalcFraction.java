package dhbw.mos.algorithms;

import java.util.Scanner;

record Fraction(double numerator, double denominator) {}

public class CalcFraction {
    static Fraction read() {
        Scanner scanner = new Scanner(System.in);
        Double numerator = null;
        while (numerator == null) {
            System.out.print("Enter numerator: ");
            try {
                numerator = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid numerator");
            }
        }

        Double denominator = null;
        while (denominator == null) {
            System.out.print("Enter denoinator: ");
            try {
                denominator = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid denominator");
            }
            if (numerator == 0.0) {
                System.out.println("Denominator cant be 0");
            }
        }

        return new Fraction(numerator, denominator);
    }

    static void output(Fraction a) {
        System.out.println("%f/%f".formatted(a.numerator(), a.denominator()));
    }

    static double value(Fraction a) {
        return a.numerator() / a.denominator();
    }

    static Fraction inverse(Fraction a) {
        return new Fraction(a.denominator(), a.numerator());
    }

    static Fraction neg(Fraction a) {
        return new Fraction(-a.numerator(), a.denominator());
    }

    static Fraction calc(Fraction a) {
        double d = gcd(a.numerator(), a.denominator());
        return new Fraction(a.numerator() / d, a.denominator() / d);
    }

    static double  gcd(double a, double b) {
        double f = 1.0;
        if (Math.max(a, b) < 0) {
            a= -a;
            b = -b;
            f = -1.0;
        }

        for (double d = Math.min(a, b); d > 0; d--) {
            if (a % d == 0 && b % d == 0) {
                return d * f;
            }
        }
        return 1.0;
    }

    public static void main(String[] args) {
        Fraction f = read();
        output(f);
        System.out.println(value(f));
        System.out.println(inverse(f));
        System.out.println(neg(f));
        System.out.println(calc(f));
    }
}
