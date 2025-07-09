package dhbw.mos.algorithms;

import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Optional;

public class HashTable<K, V> {
    private final int m;
    private final Entry<K, V>[] A;
    private int collisions = 0;

    public HashTable(int m) {
        this.m = m;
        this.A = new Entry[m];
    }

    public void insert(K key, V value) {
        int i = h(key.hashCode());
        if (A[i] != null) collisions++;
        A[i] = new Entry<>(key, value, A[i]);
    }

    public void delete(K key) {
        int i = h(key.hashCode());
        @Nullable Entry<K, V> entry = A[i];
        A[i] = null;
        while (entry != null) {
            if (!entry.key().equals(key)) {
                A[i] = new Entry<>(entry.key(), entry.value(), A[i]);
            }
            entry = entry.next();
        }
    }

    public Optional<V> get(K key) {
        int i = h(key.hashCode());
        @Nullable Entry<K, V> entry = A[i];
        while (entry != null) {
            if (entry.key().equals(key)) {
                return Optional.of(entry.value());
            }
            entry = entry.next();
        }
        return Optional.empty();
    }

    public int getCollisions() {
        return collisions;
    }

    private int h(int key) {
        return Math.abs((key ^ Integer.rotateRight(key, (key ^ 0xC0FFEE) % 32) + key * (int) Math.sqrt(key)) % m);
    }

    private record Entry<K, V>(K key, V value, @Nullable Entry<K, V> next) {}

    public static void main(String[] args) {
        HashTable<String, String> table = new HashTable<>(100 * 2);

        var first = readResource("first-names.txt");
        var last = readResource("last-names.txt");
        while (first.hasNext() && last.hasNext()) {
            table.insert(first.next(), last.next());
        }

        System.out.println(table.getCollisions());
        table.delete("franklin");
        table.delete("mazur");
        System.out.println(table.get("riki"));
    }

    private static Iterator<String> readResource(String filename) {
        return new BufferedReader(
                new InputStreamReader(
                        HashTable.class.getClassLoader().getResourceAsStream(filename)
                )
        ).lines().iterator();
    }
}
