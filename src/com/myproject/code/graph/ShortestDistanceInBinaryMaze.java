package com.myproject.code.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '0', '0'},
                {'1', '0', '0', '1'}
        };
        int sr = 0;
        int sc = 1;
        int tarRow = 2;
        int tarCol = 1;
        int ans = shortestDistance(grid, sr, sc, tarRow, tarCol);
        System.out.println(ans);
    }

    private static int shortestDistance(char[][] grid, int sr, int sc, int tarRow, int tarCol) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc, 0));
        visited[sr][sc] = 1;
        int dis = -1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.first;
            int col = pair.second;
            dis = pair.time;
            if (row == tarRow && col == tarCol) {
                return dis;
            }
            int[] di = {+1, 0, 0, -1};
            int[] dj = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++) {
                int ni = row + di[i];
                int nj = col + dj[i];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && visited[ni][nj] == 0 && grid[ni][nj] == '1') {
                    visited[ni][nj] = 1;
                    queue.add(new Pair(ni, nj, dis + 1));
                }
            }
        }
        return dis;
    }
}
