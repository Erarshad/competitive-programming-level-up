class stringSet {
    public int longestPalindromeSubseq(String s) {
        
        int dp[][]=new int[s.length()+1][s.length()+1];
     
       
        
        return longestPSQ(s,0,s.length()-1,dp);
        
        
    }
    
    private int longestPSQ(String s, int i, int j,int[][] dp){
        // LONGEST PALINDROMIC SUBSEQUENCE
        if(i>=j){
            
            return dp[i][j]=(i==j?1:0);

        }
        
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        
        int ans=0;
        if(s.charAt(i)==s.charAt(j)){
            ans+=longestPSQ(s,i+1,j-1,dp)+2;
        }else{
            ans+=Math.max(longestPSQ(s,i+1,j,dp),longestPSQ(s,i,j-1,dp));
            
        }
        
        
        return dp[i][j]=ans;
        
    }

    //===========================================================================

   // LONGEST PALINDROMIC SUBSEQUENCE TABULATION

    private int longestPSQTabu(String s, int I, int J,int[][] dp){
        for(int gap=0;gap<dp.length;gap++){// do dry run of recursive you will find it is 
            // filling in diagonal manner thats why i am doing it
            //because it is filling  in diagonal manner
            for(int i=0,j=gap;j<dp.length;i++,j++){

                //-------------

                if(i>=j){
            
                     dp[i][j]=(i==j?1:0);

                     continue;
        
                }
                
              
                
             
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;//    longestPSQ(s,i+1,j-1,dp)+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    
                }
                
          

                //---




            }
            
        }



        return dp[I][J];
      
        
    }
    //----------------------------------------------------------
    //longest commmon subsequence RECURSION +memo

    public int lcss(String text1, String text2,int n,int m,int dp[][]){  
        if(n==0 || m==0)
            return 0;
        if(dp[n][m]!=-1)
            return dp[n][m];
        if(text1.charAt(n-1)==text2.charAt(m-1))
           dp[n][m]=lcss(text1,text2,n-1,m-1,dp)+1;
        else{ dp[n][m]=Math.max(lcss(text1,text2,n-1,m,dp),lcss(text1,text2,n,m-1,dp));}
       return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
                dp[i][j]=-1;
            }
        }
        return lcss(text1,text2,text1.length(),text2.length(),dp);  
    } 
    //------------------ lect 4 dp

        //--leetcode 115 distinct subsequence
        public int numDistinct(String s, String t) {
        
            int[][]dp=new int[s.length()+1][t.length()+1];
            
            for(int i[]:dp){
                Arrays.fill(i,-1);
            }
            
            return waysCreate(s,t,s.length(),t.length(),dp);
            
        }
        
        private int waysCreate(String s, String t,int n, int m,int[][]dp){
            
            
            if(m==0){
                return dp[n][m]= 1;
            }
            
            
            if(n<m){
                return dp[n][m]= 0;
            }
            
            if(dp[n][m]!=-1){
                
                return dp[n][m];
            }
            
            
            
             
            int a= waysCreate(s,t,n-1,m-1,dp);
            int b=waysCreate(s,t,n-1,m,dp);
            
            if(s.charAt(n-1)==t.charAt(m-1))
            {
                return dp[n][m]= a+b;
            }   else{
                return dp[n][m]= b;
            }     
            
    
            
            
            
            
            
        }
        //--------------------------

        // edit distance lc 72
        public int minDistance(String word1, String word2) {
            int[][] cache=new int[word1.length()+1][word2.length()+1];
            for(int i[]: cache){
                Arrays.fill(i,-1);
            }
            
            return minDistance(word1,word2,word1.length(),word2.length(), cache);
        }
        
        private int minDistance(String word1,String word2,int n,int m,int[][]cache){
            
            if(n==0 || m==0){
                return cache[n][m]=(n==0)?m:n;
            }
            
            if(cache[n][m]!=-1){
                
                return cache[n][m];
                
            }
            
            
            int insert=minDistance(word1,word2,n,m-1,cache);
            int delete=minDistance(word1,word2,n-1,m,cache);
            int replace=minDistance(word1,word2,n-1,m-1,cache);
            
            if(word1.charAt(n-1)==word2.charAt(m-1)){
                return cache[n][m]= replace; //why i am returning replace because if same we need to do n-1,m-1
            }
            
            else
            {
                return cache[n][m]= Math.min(insert,Math.min(delete,replace))+1;
            }
            
        }
        //---------------
        // wild card match recursion

        public boolean isMatch(String s, String p) {
     
            String str="";
            
            int i=0;
            char prev='\0';
            // removing consecutive stars i.e **a*b to *a*b
            
            while (i<p.length()){
                
                if(prev=='*' && prev==p.charAt(i)){
                    
                    i++;
                    continue;
                    
                    
                }else{
                    str+=p.charAt(i);
                }
             
                
                
                
                
                
                prev=p.charAt(i);
                   i++;
                
                
                
            }
            
            //--------------------------------------
            
            
            
            
                
            
            
            return isMatch(s,str,s.length(),str.length());
            
            
            
        }
        
        
        private boolean isMatch(String s, String p,int m,int n){
            
            if(m==0 || n==0){
                
                if(m==0 && n==0){
                    return true;
                }
                
                if(n==1 && p.charAt(n-1)=='*'){
                    return true;
                    
                }
                
                return false;
                
            }
            
            
            
            
            if(s.charAt(m-1)==p.charAt(n-1) || p.charAt(n-1)=='?'){
                
                
                
                return isMatch(s,p,m-1,n-1);
                
            }
            else if(p.charAt(n-1)=='*'){
                
               
                
              return   isMatch(s,p,m-1,n) || isMatch(s,p,m,n-1);
                
                
                
                
            }else{
                return false;
            }
            
            
            
            
            
            
            
            
            
        }

        //------------with dp to optimize
        public boolean isMatch(String s, String p) {
     
            String str="";
            
            int i=0;
            char prev='\0';
            
            while (i<p.length()){
                
                if(prev=='*' && prev==p.charAt(i)){
                    
                    i++;
                    continue;
                    
                    
                }else{
                    str+=p.charAt(i);
                }
             
                
                
                
                
                
                prev=p.charAt(i);
                   i++;
                
                
                
            }
            
            //--------------------------------------
            int[][] dp=new int[s.length()+1][str.length()+1];
            
            for(int[]j:dp){
                Arrays.fill(j,-1);
            }
            
            
                
            
            
            return isMatch(s,str,s.length(),str.length(),dp)==1;
            
            
            
        }
        
        
        private int isMatch(String s, String p,int m,int n, int[][] dp){
            
            if(m==0 || n==0){
                
                if(m==0 && n==0){
                    
                    return  dp[m][n]= 1;
                }
                
                if(n==1 && p.charAt(n-1)=='*'){
                       
                    return dp[m][n]=1;
                    
                }
                
               
                
                return  dp[m][n]=0;
                
            }
            
            if(dp[m][n]!=-1){
                return dp[m][n];
            }
            
            
            
            
            
            
            if(s.charAt(m-1)==p.charAt(n-1) || p.charAt(n-1)=='?'){
                
                
                
                return dp[m][n]= isMatch(s,p,m-1,n-1,dp);
                
            }
            else if(p.charAt(n-1)=='*'){
                
                boolean res=false;
                
                res=res||isMatch(s,p,m-1,n,dp)==1;
                res=res||isMatch(s,p,m,n-1,dp)==1;
                
            
                
                return     dp[m][n]=res?1:0;
                
                
               
                
              
                
                
                
                
            }else{
                
              
                return   dp[m][n]= 0;
            }
            
            
            
            
            
            
            
            
            
        }
        
        //---- lecture 5  substring type question starts from here

        public String longestPalindrome(String s) {
        
            boolean[][] dp=new boolean[s.length()][s.length()];
            int maxlen=0;
            int count=0;
            int si=0;
            for(int gap=0;gap<s.length();gap++){
                for(int i=0,j=gap;j<s.length();i++,j++){
                    if(gap==0){
                        dp[i][j]=true;
                    }
                    else if(gap==1 && s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=(s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
                    }
                    
                    
                    if(dp[i][j]){
                        count++;
                        if(j-i+1> maxlen){
                            maxlen=j-i+1;
                            si=i;
                        }
                    }
                    
                }
            }
            
            
            return s.substring(si,si+maxlen);
            
            
            
        }
        
        



}