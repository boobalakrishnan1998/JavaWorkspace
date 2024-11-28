package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPointGraph {
    private static int timer = 1;

    /* Helper function to make DFS calls while
    identifying articulation points */
    private static void dfs(int node, int parent, boolean[] vis,
                            int[] tin, int[] low, boolean[] mark,
                            ArrayList<ArrayList<Integer>> adj) {

        // Mark the node as visited
        vis[node] = true;

        /* Time of insertion and the lowest time of
        insert for node will be the current time */
        tin[node] = low[node] = timer;

        // Increment the timer
        timer++;

        // To count the number of children of the node
        int child = 0;

        // Traverse all its neighbor
        for (int it : adj.get(node)) {

            // Skip the parent
            if (it == parent) continue;

            // If a neighbor is not visited
            if (!vis[it]) {

                // Make a recursive DFS call
                dfs(it, node, vis, tin, low, mark, adj);

                /* Once the recursive DFS call returns, upate
                the lowest time of insertion for the node */
                low[node] = Math.min(low[node], low[it]);

                /* If the lowest time of insertion of the node is
                found to be greater than the time of insertion
                of the neighbor and it is node the starting node */
                if (low[it] >= tin[node] && parent != -1) {

                    // Mark the node as an articulation point
                    mark[node] = true;
                }

                // Increment the child counter
                child++;
            }

            // Else if the neighbor is already visited
            else {

                // Update the lowest time of insertion of the node
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        /* If the node is not a starting node
        and has more than one child */
        if (child > 1 && parent == -1) {

            // Mark the node as an articulation point
            mark[node] = true;
        }
    }

    /* Function to determine the articulation
    points in the given graph */
    public static ArrayList<Integer> articulationPoints(int n,
                                                        ArrayList<ArrayList<Integer>> adj) {

        // Visited array
        boolean[] vis = new boolean[n];

        // To store the time of insertion(discovery time) of nodes
        int[] tin = new int[n];

        // To store the lowest time of insert of the nodes
        int[] low = new int[n];

        // To mark if a node is an articulation point
        boolean[] mark = new boolean[n];

        // Start DFS traversal of the graph
        for (int i = 0; i < n; i++) {

            // If a node is not visited
            if (!vis[i]) {

                // Perform DFS starting from that node
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        // To store the nodes that are articulation point
        ArrayList<Integer> ans = new ArrayList<>();

        // Traverse all nodes
        for (int i = 0; i < n; i++) {

            // If the node is marked as an articulation point
            if (mark[i]) {
                // Add it to the result
                ans.add(i);
            }
        }

        // If there are no articulation points, return -1
        if (ans.size() == 0)
            return new ArrayList<>(Arrays.asList(-1));

        // Return the result
        return ans;
    }

    public static void main(String[] args) {
        int V = 7;
        // Converting graph in adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).addAll(Arrays.asList(1, 2, 3));
        adj.get(1).addAll(Arrays.asList(0));
        adj.get(2).addAll(Arrays.asList(0, 3, 4, 5));
        adj.get(3).addAll(Arrays.asList(2, 0));
        adj.get(4).addAll(Arrays.asList(2, 6));
        adj.get(5).addAll(Arrays.asList(2, 6));
        adj.get(6).addAll(Arrays.asList(4, 5));

        /* Function call to get all the
        articulation points in the given graph */
        ArrayList<Integer> nodes = articulationPoints(V, adj);

        // Output
        for (int node : nodes) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
