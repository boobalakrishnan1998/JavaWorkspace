package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {

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
        dfs(0, board, res);
        return res;
    }

    private static void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isValid(row, col, board)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private static boolean isValid(int row, int col, char[][] board) {
        int tempRow = row;
        int tempCol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row--;
        }
        row = tempRow;
        col = tempCol;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = tempRow;
        col = tempCol;
        while (row <= board.length - 1 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row++;
        }
        return true;
    }
}
