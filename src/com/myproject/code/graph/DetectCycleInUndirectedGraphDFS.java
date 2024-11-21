package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraphDFS {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        boolean ans = detectCycle(n, adj);
        System.out.println(ans);
    }
    private static boolean detectCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[n];
        for (int i = 1; i < n; i++) {
            if (visited[i] == 0) {
                if (cycleByDfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
// this will check all node and like loop
    private static boolean cycleByDfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        List<Integer> adjList = adj.get(node);
        visited[node] = 1;
        for (Integer adjNode : adjList) {
            if (visited[adjNode] == 0) {
                if (cycleByDfs(adjNode, node, adj, visited)) {
                    return true;
                }
            } else if (adjNode != parent) {
                return true;
            }
        }
        return false;
    }
}
