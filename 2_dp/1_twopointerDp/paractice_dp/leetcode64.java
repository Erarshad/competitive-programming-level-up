class Solution {
   
    public int minPathSum(int[][] grid) {
        int[][] dir={{0,1},{1,0}};
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        
    //   int val= minPathSum(grid,dir,0,0,grid.length-1,grid[0].length-1,dp);
            
//           for(int i[]: dp){
//               for(int j: i){
//                   System.out.print(j+" ");
//               }
              
//               System.out.println();
//           }
          
        
        
        
       // return val;
        
        return minPathSum_tabu(grid,dir,0,0,grid.length-1,grid[0].length-1,dp);
        
        
        
    }
    
    
    private int minPathSum(int[][] grid, int[][] dirs, int sr, int sc, int dr, int dc,int[][] dp){
        
        if(sr==dr && sc==dc){
            
            return dp[sr][sc]= grid[sr][sc];
            
        }
        
        
        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }
        
        
        
        int sum=(int)1e9;
        for(int[] dir: dirs){
            int row=sr+dir[0];
            int col=sc+dir[1];
            if(row>=0 && row<=dr && col>=0 && col<=dc){
                sum=Math.min(minPathSum(grid,dirs,row,col,dr,dc,dp)+grid[sr][sc],sum);
            }
        }
        
        
        return dp[sr][sc]= sum;
        
        
        
        
        
        
        
        
    }
    //--tabulation 
      private int minPathSum_tabu(int[][] grid, int[][] dirs, int SR, int SC, int dr, int dc,int[][] dp){
          
          for(int sr=dr;sr>=SR;sr--){
              for(int sc=dc;sc>=SC;sc--){
                  
                  
                  
         if(sr==dr && sc==dc){
            
             dp[sr][sc]= grid[sr][sc];
             
             continue;
            
        }
        
        
   
        
        int sum=(int)1e9;
        for(int[] dir: dirs){
            int row=sr+dir[0];
            int col=sc+dir[1];
            if(row>=0 && row<=dr && col>=0 && col<=dc){
                sum=Math.min(dp[row][col]+grid[sr][sc],sum);
            }
        }
        
        
         dp[sr][sc]= sum;
                  
                  
                  
                  
                  
                  
                  
        
        
        
                  
              }
          }
          
              
        
          
          
          
          return dp[0][0];
     
        
        
        
        
        
    }
}