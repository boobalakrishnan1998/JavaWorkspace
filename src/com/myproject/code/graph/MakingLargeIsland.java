package com.myproject.code.graph;

import java.util.HashSet;
import java.util.Set;

public class MakingLargeIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0},
                {0, 1}
        };
        /* Function call to get the
        size of the largest island */
        int ans = largestIsland(grid);

        // Output
        System.out.println("The size of the largest island is: " + ans);
    }

    private static void addInitialIslands(int[][] grid,
                                          DisjointSet ds, int n) {
        // Traverse all the cells in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // If the cell is not land, skip
                if (grid[row][col] == 0) continue;
                int[] delRow = {-1, 0, 1, 0};
                int[] delCol = {0, 1, 0, -1};
                // Traverse on all the neighbors
                for (int ind = 0; ind < 4; ind++) {
                    // Get the coordinates of neighbor
                    int newRow = row + delRow[ind];
                    int newCol = col + delCol[ind];

                    // If the cell is valid and a land cell
                    if (isValid(newRow, newCol, n) &&
                            grid[newRow][newCol] == 1) {
                        // Get the number for node
                        int nodeNo = row * n + col;
                        // Get the number for neighbor
                        int adjNodeNo = newRow * n + newCol;

                        /* Take union of both nodes as they
                        are part of the same island */
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
    }

    // Function to get the size of the largest island
    public static int largestIsland(int[][] grid) {
        // Dimensions of grid
        int n = grid.length;

        // Disjoint set data structure
        DisjointSet ds = new DisjointSet(n * n);

        /* Function call to add initial
        islands in the disjoint set */
        addInitialIslands(grid, ds, n);

        // To store the answer
        int ans = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        // Traverse on the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                // If the cell is a land cell, skip
                if (grid[row][col] == 1) continue;

                /* Set to store the ultimate
                parents of neighboring islands */
                Set<Integer> components = new HashSet<>();

                // Traverse on all its neighbors
                for (int ind = 0; ind < 4; ind++) {
                    // Coordinates of neighboring cell
                    int newRow = row + delRow[ind];
                    int newCol = col + delCol[ind];

                    if (isValid(newRow, newCol, n) &&
                            grid[newRow][newCol] == 1) {

                        /* Perform union and store
                        ultimate parent in the set */
                        int nodeNumber = newRow * n + newCol;
                        components.add(ds.findUPar(nodeNumber));
                    }
                }

                // To store the size of current largest island
                int sizeTotal = 0;

                // Iterate on all the neighboring ultimate parents
                for (int parent : components) {
                    // Update the size
                    sizeTotal += ds.size[ds.findUPar(parent)];
                }

                // Store the maximum size of island
                ans = Math.max(ans, sizeTotal + 1);
            }
        }

        // Edge case
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            // Keep the answer updated
            ans = Math.max(ans, ds.size[ds.findUPar(cellNo)]);
        }

        // Return the answer
        return ans;
    }

    /* Helper function to check
   if a pixel is within boundaries */
    private static boolean isValid(int i, int j, int n) {
        // Return false if pixel is invalid
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= n) return false;

        // Return true if pixel is valid
        return true;
    }
}
