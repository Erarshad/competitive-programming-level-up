// https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> semi=new ArrayList<>();
        subSet(ans,semi,nums,0);
        
        return ans;
    }
    
    private void subSet(List<List<Integer>> ans, List<Integer>semi, int[] nums, int idx){
        
        if(idx>=nums.length){
            List<Integer> li=new ArrayList<>(semi);
            ans.add(li);
            
            return;
            
        }
        
        
       
        
     
        semi.add(nums[idx]);
        subSet(ans,semi,nums,idx+1);
        semi.remove(semi.size()-1);
            
        subSet(ans,semi,nums,idx+1);
        
        
        
        
    }
}