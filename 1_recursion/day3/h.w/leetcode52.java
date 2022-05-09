class Solution {
    public int totalNQueens(int n) {
        int [][] chess=new int[n][n];
        // theory of combination 
        
      int val=  solveNqueen(chess,n,n,0);
        
        return val;
    }
    
    
    private int solveNqueen(int[][] chess, int n,int q,int idx){
        
        if(q==0){
            return 1;
        }
        
        
        
        
        int count=0;
        for(int i=idx;i<n*n;i++){
            
            int r=i/n;
            int c=i%n;
            
            if(chess[r][c]!=1 && isSafe(chess,r,c,n)){
                
                  chess[r][c]=1;
            
            
                    count+=solveNqueen(chess,n,q-1,i+1);

                    chess[r][c]=0;
                
            }
          
            
        }
        
        
        
        
        return count;
        
        
        
        
    }
    
    private boolean isSafe(int chess[][],int r, int c, int n ){

        
       int [][] dir={{0,-1},{-1,-1},{-1,1},{-1,0}};
        
        for(int i=0;i<dir.length;i++){
         // equation for circle
            
            for(int rad=1;rad<=n;rad++){
                int x=r+rad*dir[i][0];
                int y=c+rad*dir[i][1];
                
                if(x>=0 && y>=0 && x<n && y<n){
                    if(chess[x][y]==1){
                        return false;
                    }
                }
                else{
                    break;
                }
            }
            
            
        }
        
            return true;
        
        
        
    }
    
    

    
    
    
}