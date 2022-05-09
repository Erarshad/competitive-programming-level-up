//optimise approach using boolean of 2d and 3d 

import java.util.*;
class Solution {
    
   
   boolean[][] rows = new boolean[10][10];
    boolean[][] cols = new boolean[10][10];
    boolean[][][] mats = new boolean[3][3][10];

    public boolean sudokuSolver_02(char[][] board, ArrayList<Integer> list, int idx) {
        if (idx == list.size())
            return true;

        int r = list.get(idx) / 9;
        int c = list.get(idx) % 9;

        for (int num = 1; num <= 9; num++) {
            if (!rows[r][num] && !cols[c][num] && !mats[r / 3][c / 3][num]) {
                board[r][c] = (char) ('0' + num);
                rows[r][num]=true;
                cols[c][num]=true;
                mats[r/3][c/3][num]=true;
                
                 

                if (sudokuSolver_02(board, list, idx + 1))
                    return true;

                board[r][c] = '.';
                
                rows[r][num]=false;
                cols[c][num]=false;
                mats[r/3][c/3][num]=false;
                
                
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Integer> list = new ArrayList<>(); // blank places
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    list.add(i * n + j);
                } else {
                    int num = board[i][j] - '0';
                    rows[i][num]=true;
                    cols[j][num]=true;
                    mats[i/3][j/3][num]=true;
                }
            }
        }

        sudokuSolver_02(board, list, 0);
    }

   
}