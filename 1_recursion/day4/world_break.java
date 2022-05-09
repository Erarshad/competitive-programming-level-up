import java.util.*;

// https://leetcode.com/problems/word-break//

public class world_break {
    public static void main(String[] args) {
        String s="leetcode";

        List<String> worddict=new ArrayList<>();
        worddict.add("leet");
        worddict.add("code");
        HashSet<String> set=new HashSet<>();

        for(String e: worddict){
                set.add(e);
        }


      boolean ans=  wordBreak(s, set, "");
      System.out.println(ans);



        

        
    }

    private static boolean wordBreak(String str, HashSet<String>dict,String asf){

        if(str.length()==0){
            System.out.println(asf);
            return true;
        }



            
                for(int i=1;i<=str.length();i++){
                    String semi=str.substring(0, i);
                    if(dict.contains(semi)){
                       boolean val= wordBreak(str.substring(i), dict, asf+semi+"");
                       if(val){
                           return true;
                       }
                    }
                    
                }



                return false;
         





    }
}