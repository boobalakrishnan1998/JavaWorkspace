package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int N = 4, M = 2;
        int[][] edges = {
                {0, 1, 2}, {0, 2, 1}
        };
        int[] ans = findShortestDis(N, M, edges);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] findShortestDis(int N, int M, int[][] edges) {
        List<int[]>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0]; // node 1
            int v = edges[i][1]; // node 2
            int wt = edges[i][2]; // edge weight
            adj[u].add(new int[]{v, wt});
        }
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, st, vis, adj);
            }
        }
        int[] ans = shortestPath(N, st, adj);
        return ans;
    }

    private static int[] shortestPath(int N, Stack<Integer> st, List<int[]>[] adj) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (int[] it : adj[node]) {
                int adjNode = it[0];
                int adjNodeDis = it[1];
                int totalDis = adjNodeDis + dist[node];
                if (dist[adjNode] > totalDis) {
                    dist[adjNode] = totalDis;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    private static void topoSort(int node, Stack<Integer> st, int[] vis, List<int[]>[] adj) {
        vis[node] = 1;
        for (int[] it : adj[node]) {
            int adjNode = it[0];
            if (vis[adjNode] == 0) {
                topoSort(adjNode, st, vis, adj);
            }
        }
        st.push(node);
    }
}
