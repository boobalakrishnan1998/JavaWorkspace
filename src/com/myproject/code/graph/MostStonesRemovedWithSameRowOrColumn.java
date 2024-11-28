package com.myproject.code.graph;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        int n = 6;
        int[][] stones = {
                {0, 0}, {0, 1}, {1, 0},
                {1, 2}, {2, 1}, {2, 2}
        };
        /* Function call to get the
        size of the largest island */
        int ans = maxRemove(stones, n);

        // Output
        System.out.println("The size of the largest island is: " + ans);
    }

    public static int maxRemove(int[][] stones, int n) {

        /* To store the maximum row
        and column having a stone */
        int maxRow = 0;
        int maxCol = 0;

        // Iterate on all the nodes
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Disjoint Set data structure
        DisjointSet ds =
                new DisjointSet(maxRow + maxCol + 1);

        // To store the nodes having a stone in Disjoint Set
        Map<Integer, Integer> stoneNodes = new HashMap<>();

        // Iterate on all stones
        for (int[] stone : stones) {
            // Row number
            int nodeRow = stone[0];

            // Converted column number
            int nodeCol = stone[1] + maxRow + 1;

            // United two nodes
            ds.unionBySize(nodeRow, nodeCol);

            // Add the nodes to the map
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        // To store the number of connected components
        int k = 0;

        // Iterate on the set
        for (int key : stoneNodes.keySet()) {
            /* Increment the count if
            a new component is found */
            if (ds.findUPar(key) == key) {
                k++;
            }
        }

        // Return the answer
        return n - k;
    }
}
