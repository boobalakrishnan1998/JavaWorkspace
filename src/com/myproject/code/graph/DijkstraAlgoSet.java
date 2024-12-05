package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class DijkstraAlgoSet {
    public static void main(String[] args) {
        int V = 6, S = 0;
        // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> node0 = new ArrayList<>();
        node0.add(new ArrayList<>(Arrays.asList(1, 4)));
        node0.add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.add(node0);
        ArrayList<ArrayList<Integer>> node1 = new ArrayList<>();
        node1.add(new ArrayList<>(Arrays.asList(0, 4)));
        node1.add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.add(node1);
        ArrayList<ArrayList<Integer>> node2 = new ArrayList<>();
        node2.add(new ArrayList<>(Arrays.asList(0, 4)));
        node2.add(new ArrayList<>(Arrays.asList(1, 2)));
        node2.add(new ArrayList<>(Arrays.asList(3, 3)));
        node2.add(new ArrayList<>(Arrays.asList(5, 6)));
        node2.add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.add(node2);
        ArrayList<ArrayList<Integer>> node3 = new ArrayList<>();
        node3.add(new ArrayList<>(Arrays.asList(2, 3)));
        node3.add(new ArrayList<>(Arrays.asList(5, 2)));
        adj.add(node3);
        ArrayList<ArrayList<Integer>> node4 = new ArrayList<>();
        node4.add(new ArrayList<>(Arrays.asList(2, 1)));
        node4.add(new ArrayList<>(Arrays.asList(5, 3)));
        adj.add(node4);
        ArrayList<ArrayList<Integer>> node5 = new ArrayList<>();
        node5.add(new ArrayList<>(Arrays.asList(3, 2)));
        node5.add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.add(node5);
        int[] ans = shortestPath(V, S, adj);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] shortestPath(int V, int S, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        TreeSet<Pair> set = new TreeSet<>(Comparator.comparingInt(a -> a.second));
        dist[S] = 0;
        set.add(new Pair(0, S));
        while (!set.isEmpty()) {
            int node = set.first().second;
            int nodeDist = set.first().first;
            set.pollFirst();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edge = adj.get(node).get(i).get(0);
                int dis = adj.get(node).get(i).get(1);
                if (dist[edge] > nodeDist + dis) {
                    if (dist[edge] == Integer.MAX_VALUE)
                        set.remove(new Pair(dist[edge], edge));
                    dist[edge] = nodeDist + dis;
                    set.add(new Pair(nodeDist + dis, edge));
                }
            }
        }
        return dist;
    }
}