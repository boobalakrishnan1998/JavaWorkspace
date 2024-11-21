package com.myproject.code.graph;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'X', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'X'}
        };
        int ans = replaceOWithX(grid);
        System.out.println(ans);

    }

    private static int replaceOWithX(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] delRow = {+1, 0, 0, -1};
        int[] delCol = {0, -1, 1, 0};
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 'O') {
                dfs(0, i, grid, visited, delRow, delCol);
            }
            if (grid[i][0] == 'O') {
                dfs(i, 0, grid, visited, delRow, delCol);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][n - 1] == 'O') {
                dfs(i, n - 1, grid, visited, delRow, delCol);
            }
            if (grid[n - 1][i] == 'O') {
                dfs(n - 1, i, grid, visited, delRow, delCol);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 'O') {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col, char[][] grid, int[][] visited, int[] delRow, int[] delCol) {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int ni = row + delRow[i];
            int nj = col + delCol[i];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && visited[ni][nj] == 0 && grid[ni][nj] == 'O') {
                dfs(ni, nj, grid, visited, delRow, delCol);
            }
        }
    }
}
