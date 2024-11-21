package com.myproject.code.graph;

import java.util.*;

public class EventualSafeStatesBFS {
    public static void main(String[] args) {
        int V = 7;
        int n = 5;
        int[][] adj = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        ArrayList<Integer>[] adjRev = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adjRev[i] = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                adjRev[it].add(i);
            }
        }
        List<Integer> ans = topoSort(V, adjRev);
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
        Collections.sort(ans);
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