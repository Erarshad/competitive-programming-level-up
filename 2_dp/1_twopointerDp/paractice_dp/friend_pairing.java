
// https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
import java.util.*;
public class friend_pairing {
    public static void main(String[] args) {
         long val=countFriendsPairings(3);


         System.out.println(val);

        
    }
    public static  long countFriendsPairings(int n) 
    { 
        
       long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
       return countFriendsPairings(n,dp);
     
    }
    
    public static long countFriendsPairings(int n,long[] dp) 
    { 
        
        if(n==0){
            return dp[n]=1;
        }
        
        if(n==1){
            return dp[n]= 1;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        
        long alone=countFriendsPairings(n-1);
        long couple=countFriendsPairings(n-2);
        return dp[n]=alone+couple*(n-1);
     
    }

    public static long countFriendsPairings_tabu(int N,long[] dp) 
    { 
        for(int n=0;n<=N;n++){
            if(n==0){
               dp[n]=1;
               continue;
            }
            
            if(n==1){
                 dp[n]= 1;
                 continue;
            }
            
         
            
            
            long alone=dp[n-1];
            long couple=dp[n-2];
            dp[n]=alone+couple*(n-1);
        }
        
        
        return dp[N];
     
    }
    
}
