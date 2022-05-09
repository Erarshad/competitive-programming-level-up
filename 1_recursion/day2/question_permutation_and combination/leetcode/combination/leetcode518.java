// https://leetcode.com/problems/coin-change-2/
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
     return  waychange(coins,amount,0,dp);
        
        
    }
    
    
    private int waychange(int[] coins, int amount,int idx,int[][] dp){
        
        if(amount==0){
            
            return 1;
        }
        
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }
        
        
        
        int count=0;
        for(int i=idx;i<coins.length;i++){
            if(amount-coins[i]>=0){
              count+=  waychange(coins,amount-coins[i],i,dp);
            
            }
        }
        
        
        
        return dp[amount][idx]=count;
        
        
        
        
        
        
        
        
        
    }
}