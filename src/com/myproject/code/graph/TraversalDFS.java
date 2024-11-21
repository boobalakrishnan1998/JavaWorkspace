package com.myproject.code.graph;

import java.util.ArrayList;

public class TraversalDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        ArrayList<Integer> ans = dfsOfGraph(5, adj);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    private static ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        dfs(0, adj, visited, ans);
        return ans;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        ans.add(node);
        visited[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (!visited[adj.get(node).get(i)]) {
                dfs(adj.get(node).get(i), adj, visited, ans);
            }
        }
    }
}
