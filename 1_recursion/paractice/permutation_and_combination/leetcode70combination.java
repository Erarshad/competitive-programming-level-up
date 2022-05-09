// https://leetcode.com/problems/combinations/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr=new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        
       
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> semi=new ArrayList<>();
        
        combinations(ans,semi,0,arr,k);
        
        
        
        return ans;
        
        
        
        
        
        
        
    }
    
    private static void combinations(List<List<Integer>> ans, List<Integer> semi,int idx, int[] arr,int k){
        
        
        if(semi.size()==k){
            List<Integer> copy=new ArrayList<>(semi);
            ans.add(copy);
            
            return;
        }
        
        
        for(int i=idx;i<arr.length;i++){
            
            semi.add(arr[i]);
            combinations(ans,semi,i+1,arr,k);
            semi.remove(semi.size()-1);
            
        }
        
    }
}