public class l4_queencombinationMat {
    public static void main(String[] args) {
        int[][] mat=new int[3][3];
        int count=0;

       count+= queenArrangeMentCombination(mat, 3, 0, "");

        System.out.println(count);
        
    }

    private static int  queenArrangeMentCombination(int[][]boxes,int target,int idx,String psf){
        if(target==0){
 
         System.out.println(psf+" ");
         return 1;
 
        }
 
        int count=0;
         for(int i=idx;i<boxes.length*boxes.length;i++){
             int r=i/boxes.length;
             int c=i%boxes.length;
            
          
          count+=  queenArrangeMentCombination(boxes,target-1,i+1,psf+"("+r+","+c+")");
 
             
         }
 
 
         return count;
 
     }
}