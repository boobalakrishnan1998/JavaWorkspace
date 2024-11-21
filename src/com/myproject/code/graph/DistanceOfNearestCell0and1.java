package com.myproject.code.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell0and1 {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };
        int[][] ans = findNearestCell(grid);
        System.out.println(ans);
    }

    private static int[][] findNearestCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    visited[i][j] = 1;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        int[][] ans = findByBfs(grid, visited, queue);
        return ans;
    }

    private static int[][] findByBfs(char[][] grid, int[][] visited, Queue<Pair> queue) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        while (!queue.isEmpty()) {
            int sr = queue.peek().first;
            int sc = queue.peek().second;
            int time = queue.peek().time;
            queue.remove();
            ans[sr][sc] = time;
            int[] di = {+1, 0, 0, -1};
            int[] dj = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++) {
                int ni = sr + di[i];
                int nj = sc + dj[i];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && visited[ni][nj] == 0) {
                    visited[ni][nj] = 1;
                    grid[ni][nj] = (char) time;
                    queue.add(new Pair(ni, nj, time + 1));
                }
            }
        }
        return ans;
    }
}
