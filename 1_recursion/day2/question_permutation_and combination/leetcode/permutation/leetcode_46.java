// https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> semi=new ArrayList<>();
        
        
        permute(nums,0,ans,semi);
        
        return ans;
        
    }
    
    
    private void permute(int [] nums,int ele,List<List<Integer>>ans, List<Integer>semi)    {
        
        if(ele==nums.length){
            
            ArrayList<Integer> base=new ArrayList<>(semi);
            ans.add(base);
            return ;

        }
        
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-11){
            semi.add(nums[i]);
            int val=nums[i];
            nums[i]=-11;
            permute(nums,ele+1,ans,semi);
                
                semi.remove(semi.size()-1);
            
            nums[i]=val;
                
            }
            
            
        }
        
        
        

    }
}