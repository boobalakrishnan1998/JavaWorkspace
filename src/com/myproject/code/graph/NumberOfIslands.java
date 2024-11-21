package com.myproject.code.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '0', '1', '1', '0', '0', '0'},
                {'1', '0', '1', '1', '0', '1', '0'}
        };
        int ans = findNumberOfIslands(grid);
        System.out.println(ans);
    }

    private static int findNumberOfIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    bfsOfGraph(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfsOfGraph(int row1, int col1, int[][] visited, char[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(row1, col1));
        visited[row1][col1] = 1;
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()) {
            int row = q.peek().getKey();
            int col = q.peek().getValue();
            q.remove();
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nrow = row + delRow;
                    int ncol = col + delCol;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                        q.add(new Pair<>(nrow, ncol));
                        visited[nrow][ncol] = 1;
                    }
                }
            }
        }
    }
}
