import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
     
        char[][] mat=new char[n][n];
        
        for(int i=0;i<mat.length;i++){
            Arrays.fill(mat[i],'.');
        }
        
        List<List<String>> list=new ArrayList<>();
         
        for(List<String> l: list){
            l=new ArrayList<>();
        }
        
        nq(mat,0,n,n,list);
        
        
        return list;
        
        
        
        
        
        
    }
    
    
    private  void nq(char[][] mat, int idx, int target,int n,List<List<String>> result){
   
        if(target==0){
            result.add(format(mat));
            
            return;
        }
        
    
        
        for(int i=idx;i<n*n;i++){
            int r=i/n;
            int c=i%n;
            
            
            if(mat[r][c]!='Q' && issafe(mat,r,c,n)){
             
                mat[r][c]='Q';


                nq(mat,i+1,target-1,n,result);


                mat[r][c]='.';


            }
            
        }
        
        
        
        
    }
    
    
    private List<String> format(char[][] mat){
        
        List<String> out=new ArrayList<>();
        
         for(char[] row: mat){
             String form="";
             for(char ele: row){
                 
                 form+=ele;
                 
             }
             
             out.add(form);
         }
        
        
        return out;
        
    }
    
    private boolean issafe(char[][] mat, int r, int c,int n){
        
        int [][] dir={{0,-1},{-1,0},{-1,-1},{-1,1}};
        
            for(int i=0;i<dir.length;i++){
                for(int rad=1;rad<=n;rad++){
                    int row=r+rad*dir[i][0];
                    int col=c+rad*dir[i][1];
                    if(row>=0 && col>=0 && row<n && col<n){
                        if(mat[row][col]=='Q'){
                            return false;
                        }
                    }else{
                        break;
                    }
                }
 
            }
        
        
        
        return true;
        
    }
}class Solution {
    public List<List<String>> solveNQueens(int n) {
     
        char[][] mat=new char[n][n];
        
        for(int i=0;i<mat.length;i++){
            Arrays.fill(mat[i],'.');
        }
        
        List<List<String>> list=new ArrayList<>();
         
        for(List<String> l: list){
            l=new ArrayList<>();
        }
        
        nq(mat,0,n,n,list);
        
        
        return list;
        
        
        
        
        
        
    }
    
    
    private  void nq(char[][] mat, int idx, int target,int n,List<List<String>> result){
   
        if(target==0){
            result.add(format(mat));
            
            return;
        }
        
    
        
        for(int i=idx;i<n*n;i++){
            int r=i/n;
            int c=i%n;
            
            
            if(mat[r][c]!='Q' && issafe(mat,r,c,n)){
             
                mat[r][c]='Q';


                nq(mat,i+1,target-1,n,result);


                mat[r][c]='.';


            }
            
        }
        
        
        
        
    }
    
    
    private List<String> format(char[][] mat){
        
        List<String> out=new ArrayList<>();
        
         for(char[] row: mat){
             String form="";
             for(char ele: row){
                 
                 form+=ele;
                 
             }
             
             out.add(form);
         }
        
        
        return out;
        
    }
    
    private boolean issafe(char[][] mat, int r, int c,int n){
        
        int [][] dir={{0,-1},{-1,0},{-1,-1},{-1,1}};
        
            for(int i=0;i<dir.length;i++){
                for(int rad=1;rad<=n;rad++){
                    int row=r+rad*dir[i][0];
                    int col=c+rad*dir[i][1];
                    if(row>=0 && col>=0 && row<n && col<n){
                        if(mat[row][col]=='Q'){
                            return false;
                        }
                    }else{
                        break;
                    }
                }
 
            }
        
        
        
        return true;
        
    }
}