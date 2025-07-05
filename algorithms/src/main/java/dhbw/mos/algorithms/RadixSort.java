package dhbw.mos.algorithms;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    private static int[] bucketSort(int m, int[] unsorted) {
        int[] sorted = new int[unsorted.length];

        int[] nodeHeap = new int[unsorted.length];
        int[] buckets = new int[m];
        Arrays.fill(nodeHeap, -1);
        Arrays.fill(buckets, -1);

        for (int i = 0; i < unsorted.length; i++) { // Not stable since pushing from front
            int val = unsorted[i];
            nodeHeap[i] = buckets[val];
            buckets[val] = i;
        }

        int sortPos = 0;
        for (int ptr : buckets) { // O(unsorted.length)
            while (ptr != -1) {
                sorted[sortPos] = unsorted[ptr];
                sortPos++;
                ptr = nodeHeap[ptr];
            }
        }

        return sorted;
    }

    private static int[] radixSort(int[] arr) {
        int radix = 10;
        int length = arr.length;
        int[] unsorted = Arrays.copyOf(arr, length);
        int[] sorted = new int[length];

        int[] pointers = new int[length];
        int[] heads = new int[radix];
        int[] tails = new int[radix];

        int max = 1;
        for (int i : arr) if (i > max) max = i;

        int numIterations = (int) Math.ceil(Math.log10(max));

        for (int iteration = 0; iteration < numIterations; iteration++) {
            Arrays.fill(pointers, -1);
            Arrays.fill(heads, -1);
            Arrays.fill(tails, -1);

            for (int i = 0; i < unsorted.length; i++) {
                int val = (unsorted[i] / (int) Math.pow(radix, iteration)) % radix;
                if (heads[val] == -1) heads[val] = i;
                else pointers[tails[val]] = i;
                tails[val] = i;
            }

            int sortPos = 0;
            for (int ptr : heads) {
                while (ptr != -1) {
                    sorted[sortPos] = unsorted[ptr];
                    sortPos++;
                    ptr = pointers[ptr];
                }
            }

            int[] temp = unsorted;
            unsorted = sorted;
            sorted = temp;
        }

        return unsorted;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 3, 1, 3, 1, 3, 5 };
        int[] sorted = bucketSort(10, arr);
        System.out.println(Arrays.toString(sorted));

        Random rng = new Random();
        int[] radixStart = rng.ints().map(Math::abs).limit(10).toArray();
//        int[] radixStart = new int[] { 105, 14, 38, 234, 7 };
        System.out.println(Arrays.toString(radixStart));
        System.out.println(Arrays.toString(radixSort(radixStart)));
    }
}
