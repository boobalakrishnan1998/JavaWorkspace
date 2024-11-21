package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphBFS {
    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1);
        adj[1].add(2);
        adj[1].add(5);
        adj[2].add(3);
        adj[3].add(4);
        adj[4].add(1);
        boolean ans = isCyclic(V, adj);
        System.out.println(ans);
    }

    private static boolean isCyclic(int n, List<Integer>[] adj) {
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
        int count = bfsCheck(que, adj, inDegree);
        if (n == count) {
            return false;
        }
        return true;
    }

    private static int bfsCheck(Queue<Integer> que, List<Integer>[] adj, int[] inDegree) {
        int count = 0;
        while (!que.isEmpty()) {
            int node = que.remove();
            count++;
            for (int adjNode : adj[node]) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    que.add(adjNode);
                }
            }
        }
        return count;
    }
}
