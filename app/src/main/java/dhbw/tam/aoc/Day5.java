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
        Path path = Path.of(args[0]);
        String rawInput = Files.readString(path);

        String[] splitRawInput = rawInput.split("\n\n");
        String rawOrders = splitRawInput[0];
        String rawUpdates = splitRawInput[1];

        List<Order> orders = rawOrders
                .lines()
                .map(line -> {
                    String[] splitLine = line.split("\\|");
                    int first = Integer.parseInt(splitLine[0]);
                    int after = Integer.parseInt(splitLine[1]);
                    return new Order(first, after);
                })
                .toList();

        List<List<Integer>> updates = rawUpdates
                .lines()
                .map(line -> List.of(line.split(",")))
                .map(pages -> pages
                        .stream()
                        .map(Integer::valueOf)
                        .toList()
                )
                .toList();

        List<List<Integer>> correctUpdates = updates
                .stream()
                .filter(update -> IntStream.range(0, update.size()).allMatch(index -> {
                    int page = update.get(index);
                    List<Integer> before = update.subList(0, index);

                    return orders
                            .stream()
                            .filter(order -> order.first() == page).map(Order::after)
                            .noneMatch(before::contains);
                }))
                .toList();

        int result = correctUpdates
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
