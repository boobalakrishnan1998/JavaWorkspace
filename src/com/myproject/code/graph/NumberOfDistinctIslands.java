package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '0', '1', '0', '1'},
                {'0', '0', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '0', '1', '0'}
        };
        int ans = findDistinctIsland(grid);
        System.out.println(ans);

    }

    private static int findDistinctIsland(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] delRow = {+1, 0, 0, -1};
        int[] delCol = {0, -1, 1, 0};
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, i, j, list, grid, visited, delRow, delCol);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private static void dfs(int row, int col, int brow, int bcol, ArrayList<String> list, char[][] grid, int[][] visited, int[] delRow, int[] delCol) {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        String rowSt = String.valueOf((row - brow));
        String colSt = String.valueOf((col - bcol));
        list.add(rowSt + "," + colSt);
        for (int i = 0; i < 4; i++) {
            int ni = row + delRow[i];
            int nj = col + delCol[i];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && visited[ni][nj] == 0 && grid[ni][nj] == '1') {
                dfs(ni, nj, brow, bcol, list, grid, visited, delRow, delCol);
            }
        }
    }
}
