// https://leetcode.com/problems/find-the-winner-of-the-circular-game/
class Solution {
    public int findTheWinner(int n, int k) {
        
      return TheWinner(n,k)+1;
        
        
        
        
        
        
        
        
    }
    
    public int TheWinner(int n, int k) {
        
        
        if(n==1){

        return 0;
        }
        
        
        
        
        
        int prev=TheWinner(n-1,k);
        int mine=(prev+k)%n;
        
        return mine;
        
        
        
        
        
        
        
        
        
        
    }
}
