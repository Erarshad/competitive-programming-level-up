//optimise approach using bit manipulation

import java.util.*;
class Solution {
    
   
   int[] rows = new int[10];
    int[] cols = new int[10];
    int[][] mats = new int[3][3];

    public boolean sudokuSolver_02(char[][] board, ArrayList<Integer> list, int idx) {
        if (idx == list.size())
            return true;

        int r = list.get(idx) / 9;
        int c = list.get(idx) % 9;

        for (int num = 1; num <= 9; num++) {
            if ((rows[r]& mask)==0 && (cols[c]&mask)==0 && (mats[r / 3][c / 3]&mask)==0) {
                board[r][c] = (char) ('0' + num);
                rows[r]^=mask;  // making true
                cols[c]^=mask;// makingg true;
                mats[r/3][c/3]^=mask; //making  true
                
                 

                if (sudokuSolver_02(board, list, idx + 1))
                    return true;

                board[r][c] = '.';

                int onesc=~(1<<num);  // 1s compliment
                
                rows[r] &=onesc;  //making false
                cols[c]&=onesc; //making false;
                mats[r/3][c/3]&=onesc;  // making false;
                
                
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
                    int mask=1<<num;
                    rows[i]=rows[i]^mask;
                    cols[j]=cols[j]^mask;
                    mats[i/3][j/3]=mats[i/3][j/3]^mask;
                }
            }
        }

        sudokuSolver_02(board, list, 0);
    }

   
}