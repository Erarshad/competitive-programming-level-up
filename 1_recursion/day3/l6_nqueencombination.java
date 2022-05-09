public class l6_nqueencombination {
    public static void main(String[] args) {
        
       int[][]  mat =new int[4][4];
     int val=  nqueen(mat,3,"",0);
    
     System.out.println(val);
    }

    private static boolean issafe(int [][] mat, int r, int c){

        int n=mat.length;
        int [][] dir={ { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

        for(int i=0;i<dir.length;i++){
            for(int rad=1;rad<=n;rad++){
                int row=r+rad*dir[i][0];
                int col=c+rad*dir[i][1];
                if(row>=0 && row<n && col>=0 && col<n){
                    if(mat[row][col]==1){
                        return false;
                    }
                }else{
                    break;
                }
            }
        }


        return true;




    }

    private static int nqueen(int[][] mat, int target, String asf,int idx){


        if(target==0){
            System.out.println(asf);
            return 1;
        }


        int count=0;
        for(int i=idx;i<mat.length*mat.length;i++){
            int r=i/mat.length;
            int c=i%mat.length;
            
            if(mat[r][c]==0 && issafe(mat,r,c)){
            
            mat[r][c]=1; // places the queen

           count+= nqueen(mat, target-1, asf+"("+r+","+c+")", i+1);

            mat[r][c]=0; //unplaces the queen

            }
        }



        return count;






    





        

    }
}