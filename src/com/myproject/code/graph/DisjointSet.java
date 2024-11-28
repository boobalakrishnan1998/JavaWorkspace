package com.myproject.code.graph;

public class DisjointSet {
    int[] rank;
    int[] size;
    int[] parent;

    public DisjointSet(int n) {
        rank = new int[n + 1];
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        // Disjoint Data structure
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2); // Adding edge between 1 and 2
        ds.unionBySize(2, 3); // Adding edge between 2 and 3
        ds.unionBySize(4, 5); // Adding edge between 4 and 5
        ds.unionBySize(6, 7); // Adding edge between 6 and 7
        ds.unionBySize(5, 6); // Adding edge between 5 and 6

        /* Checking if node 3 and node 7
        are in the same component */
        if (ds.find(3, 7))
            System.out.println("They belong to the same components.");
        else
            System.out.println("They do not belong to the same components.");

        ds.unionBySize(3, 7); // Adding edge between 3 and 7

        /* Checking again if node 3 and node 7
        are in the same component */
        if (ds.find(3, 7))
            System.out.println("They belong to the same components.");
        else
            System.out.println("They do not belong to the same components.");
    }

    private boolean find(int u, int v) {
        return findUPar(parent[u]) == findUPar(parent[v]);
    }

    int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUPar(parent[node]);
    }

    private void unionByRank(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        if (pu == pv) return;
        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        if (rank[pu] == rank[pv]) {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        if (pu == pv) return;
        if (size[pu] > rank[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}
