package dhbw.mos.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

record Person(String name, String surname, int age, int id) {}

public class PersonSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<name>[a-zA-Z]+),(?<surname>[a-zA-Z]+),(?<age>\\d+)");

        int currentId = 0;
        List<Person> people = new ArrayList<>();

        while(true) {
            System.out.print("Please enter 'NAME,SURNAME,AGE' of person: ");
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (line.isEmpty()) break;
            if (!matcher.matches()) {
                System.out.println("Invalid input");
                continue;
            }

            people.add(new Person(
                    matcher.group("name"),
                    matcher.group("surname"),
                    Integer.parseUnsignedInt(matcher.group("age")),
                    currentId++
            ));
        }

        var sorted = people.stream()
                .sorted(Comparator.comparingInt(Person::age))
                .toList();

        var max = people.stream().mapToInt(Person::age).max();
        var min = people.stream().mapToInt(Person::age).min();
        var mean = people.stream().mapToDouble(Person::age).average().orElse(0.0);
        var variance = people.stream()
                .mapToDouble(Person::age)
                .map(a -> (a - mean) * (a - mean) / people.size())
                .sum();


        System.out.println("Sorted: " + sorted);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Variance: " + variance);
    }
}
