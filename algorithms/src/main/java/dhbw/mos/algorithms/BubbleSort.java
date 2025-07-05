package dhbw.mos.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers to sort: ");
        String numberListString = scanner.nextLine();

        int[] numbers = Arrays.stream(numberListString.split(", *"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count = numbers.length;
        System.out.println("Sorting " + Arrays.toString(numbers));

        for (int k=1; k < count; k++) {
            for (int j=0; j < count - 1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        System.out.println("Done " + Arrays.toString(numbers));

    }
}