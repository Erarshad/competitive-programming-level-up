public class devide_in_k_group {
    // https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
    public static void main(String[] args) {
        int n=3;
        int k=2;
        int[][] dp=new int[n+1][k+1];
       // System.out.println(devide_in_k_group(3, 2));
       System.out.println(devide_in_k_groupDp(n, k, dp));
        
    }

    private static int devide_in_k_group(int n, int k){

        if(n==k || k==1){
            return 1;
        }




        int self=devide_in_k_group(n-1, k-1);
        int neglect=devide_in_k_group(n-1, k)*k;

        return self+neglect;


    }

    private static int devide_in_k_groupDp(int n, int k,int[][] dp){

        if(n==k || k==1){
            return dp[n][k]=1;
        }




        int self=devide_in_k_group(n-1, k-1);
        int neglect=devide_in_k_group(n-1, k)*k;

        return dp[n][k]= self+neglect;


    }


    
}
