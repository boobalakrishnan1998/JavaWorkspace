package com.myproject.code.graph;

import java.util.*;

public class ShortestPathInUnDirectedGraph {
    public static void main(String[] args) {
        int N = 9, M = 10;
        int[][] edges = {
                {0, 1}, {0, 3}, {3, 4},
                {4, 5}, {5, 6}, {1, 2},
                {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };
        int[] ans = findShortestDis(N, M, edges);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] findShortestDis(int N, int M, int[][] edges) {
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0]; // node 1
            int v = edges[i][1]; // node 2
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] ans = shortestPath(N, adj);
        return ans;
    }

    private static int[] shortestPath(int N, List<Integer>[] adj) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0));
        while (!que.isEmpty()) {
            Pair pair = que.remove();
            int node = pair.first;
            int nodeDis = pair.second;
            for (int adjNode : adj[node]) {
                int totalDis = 1 + nodeDis;
                if (dist[adjNode] > totalDis) {
                    dist[adjNode] = totalDis;
                    que.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
}
