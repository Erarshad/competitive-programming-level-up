class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp=new int[m][n];
         for(int i[]: dp){
             
             Arrays.fill(i,-1);

         }
        return uniquePaths(0,0,m-1,n-1,new int[][]{{1,0},{0,1}},dp);
        
        
        
    }
    private int uniquePaths(int sr, int sc, int dr, int dc, int[][] dir,int[][]dp){
        
        if(sr==dr && sc==dc){
            
            return dp[sr][sc]=1;

        }
    
        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }
        
        int count=0;
        for(int i=0;i<dir.length;i++){
            int r=sr+dir[i][0];
            int c=sc+dir[i][1];
            
            if(r>=0 && r<=dr && c>=0 && c<=dc){
                count+=uniquePaths(r,c,dr,dc,dir,dp);
                
            }
            
            
            
        }

        
        return dp[sr][sc]=count;
        
    }
}