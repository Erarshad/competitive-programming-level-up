public class l2_queenCombination {
    public static void main(String[] args) {
        
       int val= queenArrangeMentCombination(new int[6], 3, 0, 0,"");
        
       System.out.println(val);
    }


    private static int  queenArrangeMentCombination(int[]boxes,int target,int idx,int qpsf,String psf){
       if(target==qpsf){

        System.out.println(psf+" ");
        return 1;

       }

       int count=0;
        for(int i=idx;i<boxes.length;i++){
         
         count+=  queenArrangeMentCombination(boxes,target,i+1,qpsf+1,psf+"p"+i+"q"+qpsf+"  ");

            
        }


        return count;

    }

    
}
