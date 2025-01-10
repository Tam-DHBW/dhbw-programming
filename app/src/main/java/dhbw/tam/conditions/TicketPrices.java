package dhbw.tam.conditions;

import java.util.Random;

enum PersonKind {
    STUDENT,
    SENIOR,
    OTHER,
}

record Customer(PersonKind kind, int age) {
    static final double BASE_PRICE = 100.0;
    static final double STUDENT_MULTIPLIER = 0.9;
    static final int STUDENT_MAX_AGE = 30;
    static final double SENIOR_MULTIPLIER = 0.85;

    public double calculateTicketPrice() {
        return BASE_PRICE * this.getPriceMultiplier();
    }

    double getPriceMultiplier() {
        if (this.kind() == PersonKind.SENIOR) {
            return SENIOR_MULTIPLIER;
        }
        else if (this.kind() == PersonKind.STUDENT && this.age() < STUDENT_MAX_AGE) {
            return STUDENT_MULTIPLIER;
        }
        else {
            return 1.0;
        }
    }
}

public class TicketPrices {
    public static void main(String[] args) {
        calculateRandom();
        calculateRandom();
        calculateRandom();
        calculateRandom();
        calculateRandom();
        calculateRandom();
    }



    static final Random rng = new Random(System.currentTimeMillis());
    static void calculateRandom() {
        PersonKind kind = PersonKind.values()[rng.nextInt(PersonKind.values().length)];
        int age = rng.nextInt(100);
        Customer customer = new Customer(kind, age);
        System.out.println("Person: " + customer);
        System.out.println("Price: " + customer.calculateTicketPrice());
    }

}
