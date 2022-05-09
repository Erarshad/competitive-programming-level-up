// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    
    private static String[] keys={"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        
        
        if(digits.length()==0){
            return new ArrayList<>();
        }
        ArrayList<String> base=new ArrayList<>();
        letterCombinations(digits,0,"",base);
        
        return base;
        
        
    }
    
    private void letterCombinations(String digits, int idx, String asf, ArrayList<String> ans)    {
        if(idx>=digits.length()){
            
            
            ans.add(asf);
            
            
            
            return;
        }
        
        
        char val=digits.charAt(idx);
        int num=val-'0';
        num-=1;
        
        for(int i=0;i<keys[num].length();i++){
       
            letterCombinations(digits,idx+1,asf+keys[num].charAt(i)+"",ans);
            
        }
        
        
        
        
        

    }
}