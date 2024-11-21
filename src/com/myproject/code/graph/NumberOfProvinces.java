package com.myproject.code.graph;

import java.util.ArrayList;

public class NumberOfProvinces {
    public static void main(String[] args) {
        // adjacency matrix
        ArrayList<ArrayList<Integer> > adjMat = new ArrayList<>();
        adjMat.add(new ArrayList<>());
        adjMat.get(0).add(0, 1);
        adjMat.get(0).add(1, 0);
        adjMat.get(0).add(2, 1);
        adjMat.add(new ArrayList<>());
        adjMat.get(1).add(0, 0);
        adjMat.get(1).add(1, 1);
        adjMat.get(1).add(2, 0);
        adjMat.add(new ArrayList<>());
        adjMat.get(2).add(0, 1);
        adjMat.get(2).add(1, 0);
        adjMat.get(2).add(2, 1);
        int numberOfProvinces = findNumberOfProvinces(3, adjMat);
        System.out.println(numberOfProvinces);
    }

    private static int findNumberOfProvinces(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i = 0; i< v; i++) {
            adjLs.add(new ArrayList<>());
        }
        for(int i = 0; i< v; i++){
            for(int j = 0; j< v; j++){
                if(adj.get(i).get(i)==1 && i!= j ){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[v];
        visited[0] = true;
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (!visited[adj.get(node).get(i)]) {
                dfs(adj.get(node).get(i), adj, visited);
            }
        }
    }
}
