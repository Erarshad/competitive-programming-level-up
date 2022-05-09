class Solution {
    public boolean exist(char[][] board, String word) {
        //ABCCED
      int [][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
          
                if(board[i][j]==word.charAt(0) &&  solve_word(i,j,board,word,0,dir)){
                  return true;
                }
                
                
            }
        }
        
        return  false;
    }
    
    public boolean solve_word(int row,int col,char[][] board, String word,int count,int[][] dir){
        
            
        if(count==word.length()){
            return true;
        }
          
        
    if( row<0 || col<0 || row>=board.length  || col>=board[row].length || board[row][col]!=word.charAt(count)){
            return false;
        }
        
        
        
        for(int i=0;i<dir.length;i++){
            int r=row+dir[i][0];
            int c=col+dir[i][1];
            
            
            
              char val=board[row][col];
          
         
                board[row][col]='.';
            
               if(solve_word(r,c,board,word,count+1,dir)){
                   return true;
               }
                
               
                board[row][col]=val;
                
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return false;
    
        
        
        
        
      
        
        
        
        
        
    }
}public class leetcode_79_wordsearch {
    
}
