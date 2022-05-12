import java.util.*;;
public class tribonacci_lc1137 {
    public static void main(String[] args) {
        int n=35;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        // int val=triboDp(n,dp);
         int val=triboTabu(n,dp);
         System.out.println(val);
         System.out.println("----");
        System.out.println(tribo_optimize(n));
        
        
    }

   
     // using memo
    
    private static int triboDp(int n, int[] dp){
          if(n==0){
           return dp[n]= n;
       }
        
        if(n==1){
            return dp[n]= n;
            
        }
        
        if(n==2){
            return dp[n]= 1;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        
        
        return dp[n]= triboDp(n-1,dp)+triboDp(n-2,dp)+triboDp(n-3,dp);
        
    }
    // using tabulation\
    
     private static  int triboTabu(int N, int[] dp){
         for(int n=0;n<=N;n++){
              if(n==0){
               dp[n]= n;
                  continue;
              }

            if(n==1){
               dp[n]= n;
                continue;

            }

            if(n==2){
                dp[n]= 1;
                continue;
            }

          



             dp[n]= dp[n-1]+dp[n-2]+dp[n-3];
         }
         
         return dp[N];
    }

    private static int tribo_optimize(int n){
        int a=0;
        int b=1;
        int c=1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=a+b+c;
            a=b;
            b=c;
            c=sum;
        }

        return a;

    }


}