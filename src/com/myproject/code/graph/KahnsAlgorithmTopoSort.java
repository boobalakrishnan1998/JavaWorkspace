package com.myproject.code.graph;

import java.util.*;

public class KahnsAlgorithmTopoSort {
    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        List<Integer> ans = topoSort(V, adj);
        System.out.println(ans);
    }

    private static List<Integer> topoSort(int n, List<Integer>[] adj) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int node : adj[i]) {
                inDegree[node]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }

        }
        List<Integer> ans = bfsCheck(que, adj, inDegree);
        return ans;
    }

    private static List<Integer> bfsCheck(Queue<Integer> que, List<Integer>[] adj, int[] inDegree) {
        List<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int node = que.remove();
            ans.add(node);
            for (int adjNode : adj[node]) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    que.add(adjNode);
                }
            }
        }
        return ans;
    }
}
