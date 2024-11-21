package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
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
        boolean ans = isBipartite(4, adj);
        System.out.println(ans);
    }

    private static boolean isBipartite(int n, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];
        q.add(0);
        visited[0] = 1;
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (Integer li : adj.get(cur)) {
                if (visited[li] == visited[cur]) {
                    return false;
                }
                q.add(li);
                if (visited[cur] == 1) {
                    visited[li] = 2;
                } else {
                    visited[li] = 1;
                }
            }
        }
        return true;
    }
}
