package com.myproject.code.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int sr = 0;
        int sc = 0;
        int tarRow = grid.length - 1;
        int tarCol = grid[0].length - 1;
        int ans = pathWithMinEffect(grid, sr, sc, tarRow, tarCol);
        System.out.println(ans);
    }

    private static int pathWithMinEffect(int[][] grid, int sr, int sc, int tarRow, int tarCol) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][] maxDiff = new Integer[n][m];
        for (int i = 0; i < maxDiff.length; i++) {
            Arrays.fill(maxDiff[i], Integer.MAX_VALUE);
        }
        Queue<Pair> queue = new LinkedList<>();
        int diff = 0;
        queue.add(new Pair(sr, sc, diff));
        maxDiff[sr][sc] = diff;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int newRow = pair.first;
            int newCol = pair.second;
            diff = pair.time;
            if (newRow == tarRow && newCol == tarCol) {
                return diff;
            }
            int[] di = {+1, 0, 0, -1};
            int[] dj = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++) {
                int ni = newRow + di[i];
                int nj = newCol + dj[i];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    int currDiff = Math.abs(grid[ni][nj] - grid[newRow][newCol]);
                    int curMaxDif = Math.max(currDiff, diff);
                    if (currDiff < maxDiff[ni][nj]) {
                        maxDiff[ni][nj] = curMaxDif;
                        queue.add(new Pair(ni, nj, curMaxDif));
                    }
                }
            }
        }
        return -1;
    }
}
