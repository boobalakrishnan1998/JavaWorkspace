package com.myproject.code.graph;

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, -1},
                {3, 5, 4, 0}
        };
        /* Function to find the shortest distance
        between every pair of vertices. */
        shortest_distance(matrix);
        // Output
        int n = matrix.length;
        System.out.println("The shortest distance matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void shortest_distance(int[][] matrix) {

        // Getting the number of nodes
        int n = matrix.length;

        // For each intermediate node k
        for (int k = 0; k < n; k++) {

            // Check for every (i, j) pair of nodes
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    /* If k is not an intermediate
                    node, skip the iteration */
                    if (matrix[i][k] == -1 || matrix[k][j] == -1)
                        continue;

                    /* If no direct edge from
                    i to v is present */
                    if (matrix[i][j] == -1) {

                        // Update the distance
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }

                    /* Else update the distance to
                    minimum of both paths */
                    else {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
    }
}
