import java.io.*;
import java.util.*;

public class Main {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
	    
	    if(cs>ts){
	        String res="";
	        String rev="";
	        for(int i=asf.length()-1;i>=0;i--){
	            rev+=asf.charAt(i);
	        }
	        
	        res+=asf;
	        
	        if(oddc!='\0'){
	           res +=oddc;
	        }
	        
	        res+=rev;
	        System.out.println(res);
	        
	        return;
	        
	        
	        
	        
	        
	        
	    }
	    
	    
	    
	    for(char key: fmap.keySet()){
	        int freq=fmap.get(key);
	        if(freq>0){
    	        fmap.put(key,freq-1);
    	        generatepw(cs+1,ts,fmap,oddc,asf+""+key);
    	        fmap.put(key,freq);
	        }
	        
	        
	        
	        
	    }
	 
	    
	    
	    
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		//write your code here
		int ts=0;
		char oddc='\0';
		int odd_count=0;
		for(char ch: fmap.keySet()){
		    int freq=fmap.get(ch);
		    if(freq%2!=0){
		        oddc=ch;
		        odd_count++;
		    }
		    fmap.put(ch,freq/2);
		    ts+=freq/2;
		    
		    
		}
		
		if(odd_count>1){
		    System.out.println(-1);
		    return;
		}
		
		generatepw(1,ts,fmap,oddc,"");
		
		
		
	}
	
}