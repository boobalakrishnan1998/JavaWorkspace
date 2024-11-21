package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphDFS {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        boolean ans = detectCycle(V, adj);
        System.out.println(ans);
    }

    private static boolean detectCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[n];
        int[] pathVis = new int[n];
        for (int i = 1; i < n; i++) {
            if (visited[i] == 0) {
                if (cycleByDfs(i, adj, visited, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }

    // this will check all node and like loop
    private static boolean cycleByDfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVis) {
        List<Integer> adjList = adj.get(node);
        visited[node] = 1;
        pathVis[node] = 1;
        for (Integer adjNode : adjList) {
            if (visited[adjNode] == 0) {
                if (cycleByDfs(adjNode, adj, visited, pathVis)) {
                    return true;
                }
            } else if (pathVis[adjNode] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}
