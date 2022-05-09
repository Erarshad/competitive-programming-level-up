public class intro {

    public static void main(String[] args) {

        // System.out.println(fibo_dp(3,new int[4]));
        System.out.println(fibo_tabu(3,new int[4]));

        System.out.println(fibo_optimize(2));
        
    }

    private static int   fibo(int n){

        if(n==0 || n==1){ 
            return n;
        }

 

        return fibo(n-1)+fibo(n-2);
        


    }

    private static int fibo_dp(int n, int[] dp){
        if(n==0|| n==1){
            return dp[n]=n;
        }
        if(dp[n]!=0){

            return dp[n];
        }

        return dp[n]=fibo_dp(n-1,dp)+fibo_dp(n-2,dp);
    }


    private static int fibo_tabu(int N, int[] dp){
        for(int n=0;n<=N;n++){
            if(n==0 || n==1){
                dp[n]=n;
                continue;
            }

            int val=dp[n-1]+dp[n-2];
            dp[n]=val;



        }


        return dp[N];
    }

    private static int fibo_optimize(int N){
        int a=0;
        int b=1;
        int sum=0;
        for(int i=0;i<N;i++){
          
            sum=a+b;
            a=b;
            b=sum;
          
            
           
        }

        return a; // we have to tell element at index
    }
}