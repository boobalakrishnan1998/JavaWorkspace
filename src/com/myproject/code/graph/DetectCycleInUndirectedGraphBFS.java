package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraphBFS {
    public static void main(String[] args) {
        int n=8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(5).add(6);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(7).add(6);
        adj.get(7).add(5);
        boolean ans = detectCycle(n, adj);
        System.out.println(ans);
    }

    private static boolean detectCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (cycleByBfs(adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean cycleByBfs(ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, -1));
        visited[1] = 1;
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            List<Integer> adjList = adj.get(node);
            for (Integer adjNode : adjList) {
                if (visited[adjNode] == 0) {
                    visited[adjNode] = 1;
                    q.add(new Pair(adjNode, node));
                } else if (visited[adjNode] != parent) {
                    return true;
                }
            }
        }
        return false;
    }


}
