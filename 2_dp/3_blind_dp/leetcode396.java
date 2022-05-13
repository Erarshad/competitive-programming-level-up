// https://leetcode.com/problems/rotate-function/
class Solution {
    public int maxRotateFunction(int[] nums) {
        
      int sum=0;
      int sumsf=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sumsf+=i*nums[i];
            
        }
        
        
        int  max=sumsf;
        
        
        for(int i=1;i<nums.length;i++){
            
            sumsf=sumsf+sum-nums.length*nums[nums.length-i];
            
            max=Math.max(max,sumsf);
            
            
            
            
            
            
        }
        
        
        return max;
        
        
        
        
        
        
    }
}
