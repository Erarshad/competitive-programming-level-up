// https://leetcode.com/problems/powx-n/
class Solution {
    public double myPow(double x, int n) {
        
        if(n<0){
            n=Math.abs(n);
            x=1/x;
            return pow(x,n);
        }
        
        
        
        return pow(x,n);
        
     
        
       
        
        
    }
    
    
    private static double pow(double x, int n){
           if(n==0){
            return 1;
        }
        
        
        if(n==1){
            return x;
        }
        
        
        
        double recAns=pow(x,n/2);
        
      recAns=  recAns*recAns;
        if(n%2!=0){
            recAns*=x;
            
        }
        
        
        return recAns;
        
        
        
        
    }
}

