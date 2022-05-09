public class l3_queenPermute{
    public static void main(String[] args) {
        
       int val= queenArrangementpermu(new int[6], 3,  0,"");
        
       System.out.println(val);
    }


    private static int  queenArrangementpermu(int[]boxes,int target,int qpsf,String psf){
       if(target==qpsf){

        System.out.println(psf+" ");
        return 1;

       }

       int count=0;
        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i] = 1;
                count+=  queenArrangementpermu(boxes,target,qpsf+1,psf+"p"+i+"q"+qpsf+"  ");
               
                boxes[i]=0;
            }
        }


        return count;

    }

    
}
