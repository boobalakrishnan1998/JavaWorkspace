package com.myproject.code.graph;

public class FloodFillAlgo {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'2', '2', '0'},
                {'2', '2', '2'}
        };
        int sr = 2;
        int sc = 0;
        char keyCol = '2';
        char newCol = '3';
        char[][] ans = findFloodFill(grid, sr, sc, keyCol, newCol);
        System.out.println(ans);
    }

    private static char[][] findFloodFill(char[][] grid, int sr, int sc, char keyCol, char newCol) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        findByDfs(grid, sr, sc, visited, keyCol, newCol);
        return grid;
    }

    private static void findByDfs(char[][] grid, int sr, int sc, int[][] visited, char keyCol, char newCol) {
        int n = grid.length;
        int m = grid[0].length;
        visited[sr][sc] = 1;
        grid[sr][sc] = newCol;
        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        for (int i = 0; i < 4; i++) {
            int ni = sr + di[i];
            int nj = sc + dj[i];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && visited[ni][nj] == 0 && grid[ni][nj] == keyCol) {
                grid[ni][nj] = newCol;
                visited[ni][nj] = 1;
                findByDfs(grid, ni, nj, visited, keyCol, newCol);
            }
        }
    }
}
