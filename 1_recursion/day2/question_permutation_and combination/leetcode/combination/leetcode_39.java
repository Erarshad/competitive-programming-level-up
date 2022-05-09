//https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();  
        List<Integer> semi=new ArrayList<>();
        
        combinationSum(candidates,target,ans,semi,0);
        
        
        return ans;
        
    }
     
    private void combinationSum(int[] candidates,int target, List<List<Integer>>  ans, List<Integer> semi,int idx){
        
        if(target==0){
            
            List<Integer> base=new ArrayList<>(semi);
            ans.add(base);
            return;
        }
        
        
        for(int i=idx;i<candidates.length;i++){
            
            
            
            if(target-candidates[i]>=0){
               
               semi.add(candidates[i]);
              
              
               combinationSum(candidates,target-candidates[i],ans,semi,i);
               
               
               semi.remove(semi.size()-1);                
                
            }
            
            
        }
        
        
 
        
        
        
    }
}
