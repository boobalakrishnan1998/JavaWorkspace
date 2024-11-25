package com.myproject.code.graph;

import java.util.*;

public class CheapestFlightWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        // To store the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        for (int[] flight : flights) {
            ArrayList<Integer> li = new ArrayList<>();
            li.add(flight[1]);
            li.add(flight[2]);
            adj.get(flight[0]).add(li);
        }
        int src = 0, dst = 3, k = 1;
        int ans = cheapestFlightsInKStops(n, src, k, dst, adj);
        System.out.println(ans);
    }

    private static int cheapestFlightsInKStops(int V, int src, int k, int des, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> pq = new LinkedList<>();
        dist[src] = 0;
        pq.add(new Pair(0, src, 0));
        while (!pq.isEmpty()) {
            int node = pq.peek().second;
            int nodeDist = pq.peek().first;
            int stops = pq.peek().time;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edge = adj.get(node).get(i).get(0);
                int dis = adj.get(node).get(i).get(1);
                if (dist[edge] > nodeDist + dis && stops <= k) {
                    dist[edge] = nodeDist + dis;
                    pq.add(new Pair(nodeDist + dis, edge, stops + 1));
                }
            }
        }

        if (dist[des] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[des];
    }
}
