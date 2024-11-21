package com.myproject.code.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        char[][] grid = {
                {'2', '2', '2'},
                {'0', '0', '1'},
                {'2', '2', '0'}
        };
        int ans = findFloodFill(grid);
        System.out.println(ans);
    }

    private static int findFloodFill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '2') {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    Pair<Pair<Integer, Integer>, Integer> qPair = new Pair<>(pair, 0);
                    q.add(qPair);
                    visited[i][j] = 1;
                }
            }
        }
        int time = findByBfs(grid, visited, q);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    return -1;
                }
            }
        }
        return time;
    }

    private static int findByBfs(char[][] grid, int[][] visited, Queue<Pair<Pair<Integer, Integer>, Integer>> q) {
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        while (!q.isEmpty()) {
            int sr = q.peek().getKey().getKey();
            int sc = q.peek().getKey().getValue();
            time = q.peek().getValue();
            q.remove();
            int[] di = {+1, 0, 0, -1};
            int[] dj = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++) {
                int ni = sr + di[i];
                int nj = sc + dj[i];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && visited[ni][nj] == 0 && grid[ni][nj] == '1') {
                    grid[ni][nj] = '2';
                    Pair<Integer, Integer> pair = new Pair<>(ni, nj);
                    Pair<Pair<Integer, Integer>, Integer> qPair = new Pair<>(pair, time + 1);
                    q.add(qPair);
                    visited[ni][nj] = 1;
                }
            }
        }
        return time;
    }
}
