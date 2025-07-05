package dhbw.mos.algorithms;

import java.util.List;
import java.util.stream.Stream;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(mergeSort(List.of(7, 2, 1, 6, 3, 5)));
    }

    static List<Integer> mergeSort(List<Integer> unsorted) {
        if (unsorted.size() < 2) return unsorted;

        int mid = unsorted.size() / 2;

        List<Integer> left = mergeSort(unsorted.subList(0, mid));
        List<Integer> right = mergeSort(unsorted.subList(mid, unsorted.size()));

        if (left.getFirst() > right.getFirst()) {
            List<Integer> aaa = left;
            left = right;
            right = aaa;
        }

        return Stream.concat(
                left.stream(),
                right.stream()
        ).toList();
    }
}
