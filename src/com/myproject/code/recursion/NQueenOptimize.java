package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueenOptimize {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> queen = solveNQueen(n);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    private static List<List<String>> solveNQueen(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        int[] rightRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        dfs(0, board, res, rightRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    private static void dfs(int col, char[][] board, List<List<String>> res, int[] rightRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (rightRow[row] == 0 &&
                    lowerDiagonal[row + col] == 0 &&
                    upperDiagonal[board.length - 1 + col - row] == 0) {
                rightRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                board[row][col] = 'Q';
                dfs(col + 1, board, res, rightRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                rightRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
