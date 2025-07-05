package dhbw.mos.algorithms;

public class Binom {
    public static void main(String[] args) {
        System.out.println(binomIter(7, 3));
        System.out.println(binomRecursive(7, 3));
        System.out.println(binomRecursive(49, 6));
    }

    static long binomIter(long m, long k) {
        long product = 1;
        for (int i = 1; i <= k; i++) {
            product = product * (m - i + 1) / i;
        }
        return product;
    }

    static long binomRecursive(long m, long k) {
        return k > 0 ? (long) ((m - k + 1) / (double) k * binomRecursive(m, k - 1)) : 1;
    }
}
