package com.myproject.code.graph;

import java.util.*;

public class NumberOWaysToArriveDestination {
    public static void main(String[] args) {
        int n = 7, m = 20;
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(0, 6, 7),
                Arrays.asList(0, 1, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 3),
                Arrays.asList(6, 3, 3),
                Arrays.asList(3, 5, 1),
                Arrays.asList(6, 5, 1),
                Arrays.asList(2, 5, 1),
                Arrays.asList(0, 4, 5),
                Arrays.asList(4, 6, 2)
        );
        /* Function call to get the number of ways to
        arrive at destinations in the shortest possible time */
        int ans = countPaths(n, roads);
        // Output
        System.out.println("The number of ways to arrive at destinations in shortest possible time is: " + ans);
    }


    /* Function to get the number of ways to arrive
        at destinations in shortest possible time */
    public static int countPaths(int n, List<List<Integer>> roads) {

        int mod = 1000000007; // Mod value

        // To store the graph
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Adding the edges to the graph
        for (List<Integer> it : roads) {
            adj[it.get(0)].add(new int[]{it.get(1), it.get(2)});
            adj[it.get(1)].add(new int[]{it.get(0), it.get(2)});
        }

        /* Array to store the minimum
        time to get to nodes */
        long[] minTime = new long[n];
        Arrays.fill(minTime, Long.MAX_VALUE);

        /* To store the number of
        ways to reach nodes */
        int[] ways = new int[n];

        // Priority queue to store: {time, node}
        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        // Initial configuration
        minTime[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});

        // Until the priority queue is empty
        while (!pq.isEmpty()) {

            // Get the element
            long[] p = pq.poll();
            long time = p[0]; // time
            int node = (int) p[1]; // node

            // Traverse its neighbors
            for (int[] it : adj[node]) {

                int adjNode = it[0]; // adjacent node
                int travelTime = it[1]; // travel time

                /* If the current time taken is less than
                earlier known time to reach adjacent node */
                if (minTime[adjNode] > time + travelTime) {

                    // Update the time to reach adjacent node
                    minTime[adjNode] = time + travelTime;

                    // Update the number of ways
                    ways[adjNode] = ways[node];

                    // Add the new element in priority queue
                    pq.add(new long[]{minTime[adjNode], adjNode});
                }

                /* Else if the current time taken is same as
                earlier known time to reach adjacent node */
                else if (minTime[adjNode] == time + travelTime) {

                    /* Update the number of ways
                    to reach adjacent nodes */
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        // Return the result
        return ways[n - 1] % mod;
    }
}