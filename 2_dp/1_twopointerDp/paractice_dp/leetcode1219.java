class Solution {
   
    public int getMaximumGold(int[][] grid) {
        
        
        
        if(grid.length==1 && grid[0].length==1 && grid[0][0]==0){
            return 0;
        }
        
      
        
        int [][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        
        
        int[] max=new int[1];
//         max[0]=Integer.MIN_VALUE;
//         int maxGold = (int)(1e9);
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
                
//                 if(grid[i][j]!=0){
//               int goldCollected =  getMaxGold(grid,i,j,grid.length-1,grid[0].length-1,dir,0,max);
                   
//                 maxGold = Math.max(maxGold,goldCollected);  
//                     System.out.println()
//                 }
//             }
//         } 
//         return max[0]; 
        
        
        int gold = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][]visited = new boolean[m][n];
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0)
                {
                    int g = solve(i,j,grid,visited,dir);
                    // System.out.println(g);
                    gold = Math.max(gold,g);
                }
            }
        }
        
        
        return gold;
        
    }
    
    
    private int solve(int sr,int sc,int[][]grid,boolean[][]visited,int[][]dir)
    {


        /*****
         * note mark where you are standing, do not mark in your futre cells
         * thats why mark outside of loop
         */
        visited[sr][sc] = true;
        int maxGold = 0;        
        for(int []d:dir)
        {
            int r = d[0]+sr;
            int c = d[1]+sc;
            if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]==0||visited[r][c])
                continue;
            int gold = solve(r,c,grid,visited,dir);
            maxGold = Math.max(gold,maxGold);
        }
        visited[sr][sc] = false;
        
        
        
        return maxGold+grid[sr][sc];
    }
    
    private int getMaxGold(int[][] grid, int sr, int sc, int dr, int dc,int[][] dir,int sum,int[] maxsum){
       
        
        if(sum>maxsum[0]){
            maxsum[0]=sum;
        }
        
        int maxgold = 0;
   
        for(int i=0;i<dir.length;i++){
            int row=sr+dir[i][0];
             int col=sc+dir[i][1];
          
            if(row>=0 && col>=0 && col<=dc && row<=dr && grid[row][col]!=0){
                int val=grid[row][col];
                
                grid[row][col]=0;
             
              int gold  =   getMaxGold(grid,row,col,dr,dc,dir,sum+val,maxsum);
              maxgold = Math.max(gold,maxgold);
                grid[row][col]=val;
            }
        }
        return maxgold+grid[sr][sc];
    
        
    }
}