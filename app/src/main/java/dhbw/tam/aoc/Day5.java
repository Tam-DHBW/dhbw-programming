package dhbw.tam.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

record Order(int first, int after) {
}

public class Day5 {
    public static void main(String[] args) throws IOException {
        final Path path = Path.of(args[0]);
        final String rawInput = Files.readString(path);

        final String[] splitRawInput = rawInput.split("\n\n");
        final String rawOrders = splitRawInput[0];
        final String rawUpdates = splitRawInput[1];

        final List<Order> orders = rawOrders
                .lines()
                .map(line -> {
                    final String[] splitLine = line.split("\\|");
                    final int first = Integer.parseInt(splitLine[0]);
                    final int after = Integer.parseInt(splitLine[1]);
                    return new Order(first, after);
                })
                .toList();

        final List<List<Integer>> updates = rawUpdates
                .lines()
                .map(line -> List.of(line.split(",")))
                .map(pages -> pages
                        .stream()
                        .map(Integer::valueOf)
                        .toList()
                )
                .toList();

        final List<List<Integer>> correctUpdates = updates
                .stream()
                .filter(update -> IntStream.range(0, update.size()).allMatch(index -> {
                    final int page = update.get(index);
                    final List<Integer> before = update.subList(0, index);

                    return orders
                            .stream()
                            .filter(order -> order.first() == page).map(Order::after)
                            .noneMatch(before::contains);
                }))
                .toList();

        final int result = correctUpdates
                .stream()
                .map(update -> update.get(update.size() / 2))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total updates size:");
        System.out.println(updates.size());
        System.out.println("Correct updates size:");
        System.out.println(correctUpdates.size());
        System.out.println("Result:");
        System.out.println(result);
    }
}
