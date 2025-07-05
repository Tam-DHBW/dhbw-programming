package dhbw.mos.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(fibonacci(n));
        System.out.println(fibonacciMemo(new HashMap<>(), n));
        System.out.println(fibonacciArr(new int[n], 20));
    }

    static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int fibonacciMemo(HashMap<Integer, Integer> cache, int n) {
        Integer value = cache.get(n);
        if (value == null) {
            value = n < 2 ? n : fibonacciMemo(cache, n - 1) + fibonacciMemo(cache, n - 2);
            cache.put(n, value);
        }
        return value;
    }

    public static int fibonacciArr(int[] cache, int n) {
        if (n < 2) return n;
        if (cache[n - 1] == 0) cache[n - 1] = fibonacciArr(cache, n - 1) + fibonacciArr(cache, n - 2);
        return cache[n - 1];
    }
}