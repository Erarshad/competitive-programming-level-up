// https://leetcode.com/problems/permutations-ii/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> semi=new ArrayList<>();
        permute(nums,0,ans,semi);
        
        
        return ans;
        
        
        
    }
    
    private void permute(int [] nums, int ele, List<List<Integer>> al, List<Integer> semi){
        
        if(ele==nums.length){
            List<Integer> li=new ArrayList<>(semi);
            
            al.add(li);
            
            return;
        }
        
        

        int prev=-88;
        for(int i=0;i<nums.length;i++){
            
            if(prev!=nums[i] && nums[i]!=-99 ){
            
                int val=nums[i];
                semi.add(val);// addon track
                nums[i]=-99;//mark visited
                permute(nums,ele+1,al,semi);

                semi.remove(semi.size()-1);//backtrack

                nums[i]=val;// unmark visited




                
            }
             prev=nums[i];
            
            
        }
        
        
        
        
    }
}