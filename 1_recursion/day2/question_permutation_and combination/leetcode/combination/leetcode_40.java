
//https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> semi=new ArrayList<>();
         combi(candidates,target,0,ans,semi);        
        
        return ans;
        
    }
    
    
    private void combi(int[] arr, int target, int idx,List<List<Integer>> ans, List<Integer> semi){
        
        if(target==0)
        {
            List<Integer> base=new ArrayList<>(semi);
            ans.add(base);
            
            return ;
            
        }        
        
        
        
        int prev=-1;
        for(int i=idx;i<arr.length;i++){
            
            if(prev!=arr[i] && target-arr[i]>=0){
                
                semi.add(arr[i]);
                combi(arr,target-arr[i],i+1,ans,semi);
                
                semi.remove(semi.size()-1);
                
                prev=arr[i];
                
                
            }
            
        }
        

        
    }
}