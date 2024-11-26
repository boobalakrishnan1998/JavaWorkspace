package com.myproject.code.graph;

import java.util.Arrays;

public class CityWithSmallestNumberNeighbors {
    public static void main(String[] args) {
        int N = 4, M = 4;
        int[][] edges = {
                {0, 1, 3}, {1, 2, 1},
                {1, 3, 4}, {2, 3, 1}
        };
        int distanceThreshold = 4;

        /* Function to find the city with
        the smallest number of neighbors. */
        int ans = findCity(N, M, edges, distanceThreshold);

        // Output
        System.out.println("The city with smallest number of neighbors (with given threshold) is: " + ans);
    }

    /* Function to find the city with
    the smallest number of neighbors. */
    public static int findCity(int n, int m, int[][] edges,
                               int distanceThreshold) {

        // Adjacency matrix to store the graph
        int[][] adjMat = new int[n][n];
        for (int[] row : adjMat) Arrays.fill(row, (int) 1e9);

        // Filling up the adjacency matrix
        for (int[] it : edges) {
            adjMat[it[0]][it[1]] = it[2];
            adjMat[it[1]][it[0]] = it[2];
        }

        // Applying Floyd Warshall Algorithm

        // For intermediate node k
        for (int k = 0; k < n; k++) {

            // node i ---> node j
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMat[i][j] =
                            Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                }
            }
        }

        // To store the minimum count of neighbors
        int minCount = (int) 1e9;

        /* To store the answer (city having
        smallest number of neighbors) */
        int ans = -1;

        // Check every city
        for (int i = 0; i < n; i++) {

            /* To count the neighbors of given city
            having distance lesser than threshold */
            int count = 0;

            // City i ---> City j
            for (int j = 0; j < n; j++) {

                /* If the distance to reach city j from
                city i is less than threshold */
                if (i != j && adjMat[i][j] <= distanceThreshold) {

                    // Increment count
                    count++;
                }
            }

            // if current count is less than minimum count
            if (count < minCount) {

                // Update minimum count
                minCount = count;

                // Store the answer
                ans = i;
            }

            /* Else if current count is
            equal to minimum count */
            else if (count == minCount) {

                /* Update the answer (to store
                city with greater number) */
                ans = i;
            }
        }

        // Return the resulting city as answer
        return ans;
    }
}
