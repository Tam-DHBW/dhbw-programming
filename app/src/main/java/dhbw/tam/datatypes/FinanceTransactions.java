package dhbw.tam.datatypes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

enum TransactionType {
    PURCHASE, SALE
}

record Transaction(double amount, Instant date) {
    public static Transaction sale(double amount) {
        return new Transaction(amount, Instant.now());
    }

    public static Transaction purchase(double amount) {
        return new Transaction(-amount, Instant.now());
    }

    public TransactionType getType() {
        return switch ((int) Math.signum(this.amount)) {
            case 0, 1 -> TransactionType.SALE;
            case -1 -> TransactionType.PURCHASE;
            default -> throw new IllegalStateException("Unexpected value: " + (int) Math.signum(this.amount));
        };
    }
}

public class FinanceTransactions {
    public static void main(String[] args) {
        Collection<Transaction> transactions = new ArrayList<>();

        Instant start = Instant.now();
        transactions.add(Transaction.sale(100));
        transactions.add(Transaction.sale(133));
        transactions.add(Transaction.purchase(200));
        Instant end = Instant.now();
        transactions.add(Transaction.sale(55));
        transactions.add(Transaction.sale(99));

        System.out.println(getIncome(transactions));
        System.out.println(getBetween(transactions, start, end));
    }

    static double getIncome(Collection<Transaction> transactions) {
        return transactions.stream().map(Transaction::amount).reduce(0.0, Double::sum);
    }

    static long getBetween(Collection<Transaction> transactions, Instant start, Instant end) {
        return transactions
                .stream()
                .filter(transaction -> !start.isAfter(transaction.date()))
                .filter(transaction -> !end.isBefore(transaction.date()))
                .count();
    }
}
