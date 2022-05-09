public class l5_queenpermutationMat {
    public static void main(String[] args) {
        int[][] mat=new int[3][3];
        int count=0;

       count+= queenpermutation(mat, 3, "");

        System.out.println(count);
    }

    private static int queenpermutation(int [][] mat,int target, String asf ){

        if(target==0){
            System.out.println(asf);
            return 1;
        }

        int count=0;

        for(int i=0;i<mat.length*mat.length;i++){
            int r=i/mat.length; 
            int c=i%mat.length;
            if(mat[r][c]!=1){
            mat[r][c]=1;
          count+=  queenpermutation(mat, target-1, asf+"("+r+","+c+")");
          mat[r][c]=0;
            }

        }



        return count;




    }

    





}