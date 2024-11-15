package com.myproject.code.recursion;

import java.util.ArrayList;

public class RatInMaze {

    public static void main(String[] args) {
        int n = 4;
        int[][] arr = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        ArrayList<String> res = findPath(arr, n);
        for (String path : res) {
            System.out.println(path);
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        int di[] = {+1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis, di, dj);
        return ans;
    }

    private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move, int vis[][], int di[], int dj[]) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {
                vis[i][j] = 1;
                solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
                vis[i][j] = 0;
            }
        }
    }
}
