package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {
    public static void main(String[] args) {
        int V = 4;
        List<int[]> edges = Arrays.asList(
                new int[]{0, 1, 1},
                new int[]{1, 2, 2},
                new int[]{2, 3, 3},
                new int[]{0, 3, 4}
        );

        // Forming the adjacency list from edges
        List<List<List<Integer>>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            adj.get(u).add(Arrays.asList(v, wt));
            adj.get(v).add(Arrays.asList(u, wt));
        }

        /* Function call to get the sum
        of weights of edges in MST */
        int ans = spanningTree(V, adj);

        System.out.println("The sum of weights of edges in MST is: " + ans);
    }

    private static int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (List<Integer> it : adj.get(i)) {
                int wt = it.get(1);
                int v = it.get(0);
                int u = i;
                edges.add(new int[]{wt, u, v});
            }
        }
        // Creating a disjoint set of V vertices
        DisjointSet ds = new DisjointSet(V);
        // Sorting the edges based on their weights
        edges.sort(Comparator.comparingInt(o -> o[0]));
        int sum = 0;
        for (int[] edge : edges) {
            int wt = edge[0];
            int u = edge[1];
            int v = edge[2];
            if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
                sum += wt;
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }
}
