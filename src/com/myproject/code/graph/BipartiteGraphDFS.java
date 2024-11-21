package com.myproject.code.graph;

import java.util.ArrayList;

public class BipartiteGraphDFS {
    public static void main(String[] args) {
        // V = 4, E = 4
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        int[] visited = new int[4];
        boolean ans = isBipartite(0, adj, visited);
        System.out.println(ans);
    }

    private static boolean isBipartite(int start, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        for (Integer li : adj.get(start)) {
            if (visited[li] == visited[start]) {
                return false;
            }
            if (visited[li] == 0) {
                if (visited[start] == 1) {
                    visited[li] = 2;
                } else {
                    visited[li] = 3;
                }
                return isBipartite(li, adj, visited);
            }
        }
        return true;
    }
}
