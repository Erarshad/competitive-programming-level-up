public class leetcode_746 {
    public static void main(String[] args) {
        int[] cost={10,15,20};
        int val=climbStairWithCost(cost,cost.length);
        System.out.println(val);

        System.out.println("---------------------");

       val= climbStairWithCostDp(cost, cost.length,new int[cost.length+1]);
       System.out.println(val);
        
    }
    private static int climbStairWithCost(int[] cost,int n)
    {
      if(n<=1){
          return cost[n];
      }


       int onestep= climbStairWithCost(cost, n-1);
       int twostep= climbStairWithCost(cost, n-2);

       int fin=Math.min(onestep,twostep)+ (n==cost.length?0:cost[n]);
       return  fin;



    }

    private static int climbStairWithCostDp(int[] cost, int n, int[] dp){
        if(n<=1){
            return dp[n]=cost[n];
        }

        if(dp[n]!=0){
            return dp[n];
        }
  
  
         int onestep= climbStairWithCost(cost, n-1);
         int twostep= climbStairWithCost(cost, n-2);
  
         int fin=Math.min(onestep,twostep)+ (n==cost.length?0:cost[n]);
         return dp[n] = fin;
  

    }
}