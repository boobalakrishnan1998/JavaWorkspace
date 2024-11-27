package com.myproject.code.graph;

public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 4;
        int[][] Edge = {
                {0, 1},
                {0, 2},
                {1, 2}
        };
        /* Function call to get the number of
        operations to make network connected */
        int ans = solve(n, Edge);
        System.out.println("The number of operations to make network connected is: " + ans);
    }

    private static int solve(int n, int[][] edge) {
        int size = edge.length;
        if (size < n - 1) return -1;
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < size; i++) {
            ds.unionBySize(edge[i][0], edge[i][1]);
        }
        int edgeCount = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i]==i) {
                edgeCount++;
            }
        }
        return edgeCount-1;
    }
}
