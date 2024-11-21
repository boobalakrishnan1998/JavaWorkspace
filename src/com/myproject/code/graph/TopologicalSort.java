package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[2].add(3);
        adj[3].add(1);
        adj[4].add(0);
        adj[4].add(1);
        adj[5].add(0);
        adj[5].add(2);
        int[] ans = topoSort(V, adj);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] topoSort(int n, List<Integer>[] adj) {
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, st);
            }
        }
        int[] ans = new int[n];
        int k = 0;
        while (!st.isEmpty()) {
            ans[k++] = st.pop();
        }
        return ans;
    }

    private static void dfsCheck(int node, List<Integer>[] adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (int adjNode : adj[node]) {
            if (vis[adjNode] == 0) {
                dfsCheck(adjNode, adj, vis, st);
            }
        }
        st.push(node);
    }
}
