import java.util.*;
public class climbStairs_lc_37 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));

        
    }
    public static int climbStairs(int n) {
            
        int[] dp=new int[n+1];
        
        Arrays.fill(dp,-1);
        
     //   climbStairsmemo(n,dp);
         
        climbStairstabu(n,dp);
        
        
        return dp[n];
        
        
     
        
        
    }
    
    
    private static  int climbStairsmemo(int n, int [] dp){
           if(n==0){
             return  dp[n]=1;
             
        }
        
        
        if(dp[n]!=-1){
           return dp[n];
        }
        
        int count=0;
        
        
        if(n-1>=0 ){
           count+= climbStairsmemo(n-1,dp);
        }
        
        
        if(n-2>=0){
            
          count+=  climbStairsmemo(n-2,dp);

        }
        
        
        return dp[n]=count;
        
        
    }
    
    // climbstairs tabu
    
     private  static int climbStairstabu(int N, int [] dp){
         
         for(int n=0;n<=N;n++){
         
               if(n==0){
                  dp[n]=1;
                   continue;
 
                  }


        

            int count=0;


            if(n-1>=0 ){
               count+= dp[n-1];
            }


            if(n-2>=0){

              count+=  dp[n-2];
            }


             dp[n]=count;


         }
        
         return dp[N];
        
    }
    
    
}