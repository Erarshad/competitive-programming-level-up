class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length+1][amount+1];
        for(int i[]: dp)
             Arrays.fill(i,-1);
        
       int val= coinChange(coins,amount,0,dp);
        
        return val==(int)1e9?-1:val;
        
        
    }
    
    private int coinChange(int[] coins,int target, int idx,int[][] dp){
        
       
        if(target==0){
            return 0;
        }
        
        
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        
        
        
        
        
        
        
        int count =(int) 1e9;
        
        for(int i=idx;i<coins.length;i++){
            
            if(target-coins[i]>=0){
            
             count=Math.min(count,coinChange(coins,target-coins[i],i,dp)+1);
               
                
            }
        }
       
     
        return dp[idx][target]= count;
        
        
        
        
    }
}