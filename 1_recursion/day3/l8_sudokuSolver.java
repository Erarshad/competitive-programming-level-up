// https://leetcode.com/problems/sudoku-solver
import java.util.*;
class Solution {
    public void solveSudoku(char[][] board) {
        int n=9;
        
        ArrayList<Integer> idx=new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    // to save complexity going to use r*n+c=idx formula to store value
                    // although u can use pair class with list
                    idx.add(i*n+j);
                    
                    
                }
            }
        }
        
        
        
        sudokuSolver(board,idx,0,n);
        
        
        
        
        
        
        
    }
    
    private boolean sudokuSolver(char[][] board, ArrayList<Integer>li,int idx,int n){
        
        if(idx==li.size()){
            return true;
            
        }
        
        
        
        int row=li.get(idx)/n;
        int col=li.get(idx)%n;
        
        for(int i=1;i<=9;i++){
            
            if(isfeasible(board,row,col,i)){
                board[row][col]=(char) ('0'+i);
                
                if(sudokuSolver(board,li,idx+1,n)){
                    return true;
                }
                
                
                board[row][col]='.';
            }
            
            
            
            
            
            
        }
        
        return false;
        
        
        
        
        
        
        
        
      
        
        
    }
    
    private boolean isfeasible(char[][] board,int r, int c, int num){
        
        // we will check in same row
        
        
        // row
        
        for(int i=0;i<board[r].length;i++){
            if(board[r][i]-'0'==num){
                return false;
            }
        }
        
        
        //col
        
        for(int i=0;i<board.length;i++){
            if(board[i][c]-'0'==num){
                return false;
            }
        }
        
        
        
        
        
        
        //3 x3
         r=(r/3)*3;
         c=(c/3)*3;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j]-'0'==num){
                    return false;
                }
            }
        }
       
        
        
        
        
        
        
        
        return true;
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
}

