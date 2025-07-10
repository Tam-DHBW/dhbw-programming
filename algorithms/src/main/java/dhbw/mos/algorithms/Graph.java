package dhbw.mos.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static boolean bfs(int[][] adjacencies, int s, int check) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[adjacencies.length];
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.remove();
            for (int v : adjacencies[u]) {
                if (!visited[v]) {
                    Q.add(v);
                    visited[v] = true;
                    if (v == check) return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int[][] adjacencies, boolean[] visited, int s, int check) {
        if (s == check) return true;
        visited[s] = true;

        for (int n : adjacencies[s]) {
            if (!visited[n] && dfs(adjacencies, visited, n, check)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] adjacencies = new int[][] {
                /* 0 */ {1, 2 ,3},
                /* 1 */ {0, 2, 4},
                /* 2 */ {0, 1, 4, 5},
                /* 3 */ {0, 6, 7},
                /* 4 */ {1, 2, 8},
                /* 5 */ {2, 8},
                /* 6 */ {3, 7, 9},
                /* 7 */ {3, 6},
                /* 8 */ {4, 5},
                /* 9 */ {6}
        };

        System.out.println(bfs(adjacencies, 0, 7));
        System.out.println(dfs(adjacencies, new boolean[10], 0, 7));
    }
}
