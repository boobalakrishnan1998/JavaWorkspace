package com.myproject.code.graph;

import java.util.*;

public class PrimsAlgo {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(0, 3, 4)
        );

        // Forming the adjacency list from edges
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            adj.get(u).add(Arrays.asList(v, wt));
            adj.get(v).add(Arrays.asList(u, wt));
        }

        /* Function call to get the sum
        of weights of edges in MST */
        int ans = spanningTree(V, adj);

        System.out.println("The sum of weights of edges in MST is: " + ans);
    }

    private static int spanningTree(int v, List<List<List<Integer>>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int[] visited = new int[v];
        int sum = 0;
        List<int[]> mstList = new ArrayList<>();
        //{weight,desNode,srcNode} if they ask only min sum {weight,desNode}
        pq.add(new int[]{0, 0, -1});
        while (!pq.isEmpty()) {
            int weight = pq.peek()[0];
            int node = pq.peek()[1];
            int parent = pq.peek()[2];
            pq.remove();
            /* If the node is already visited,
            skip the iteration */
            if (visited[node] == 1) continue;
            sum += weight;
            if (parent != -1) {
                mstList.add(new int[]{parent, node});
            }
            visited[node] = 1;
            for (List<Integer> adjNod : adj.get(node)) {
                if (visited[adjNod.get(0)] == 0) {
                    pq.add(new int[]{adjNod.get(1), adjNod.get(0), node});
                }
            }
        }
        System.out.println(Arrays.toString(mstList.toArray()));
        return sum;
    }
}
