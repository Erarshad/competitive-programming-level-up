class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid.length>=1 && obstacleGrid[0][0]==1){

            
            return 0;
        }
        
        
        int [][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int [] i: dp){
            Arrays.fill(i,-1);
        }
        
        
        
        return robotPath(obstacleGrid,0,0,obstacleGrid.length-1,obstacleGrid[0].length-1,new int[][]{{1,0},{0,1}},dp);
        
        
    }
    
    private int robotPath(int[][] obstacleGrid,int sr, int sc, int dr, int dc,int[][] dir,int[][] dp){
        
        if(sr==dr && sc==dc){
            
            return dp[sr][sc]= 1; 
        }
        
           if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }
        
        
        
        
        
        obstacleGrid[sr][sc]=1;
     
        int count=0;
        
        for(int i=0;i<dir.length;i++){
            int r=sr+dir[i][0];
            int c=sc+dir[i][1];
            
            if(r>=0 && r<=dr && c>=0 && c<=dc && obstacleGrid[r][c]!=1){
            
            count+=robotPath(obstacleGrid,r,c,dr,dc,dir,dp);
            }
            
            
            
            
            
            
        }
        
        obstacleGrid[sr][sc]=0;
        
        
        return  dp[sr][sc]=count;
        
        
        
    }
}