import java.util.*;

public class countsubarraysum_hashmap {
    // here we have to count the count the subarray that have sum of given target

    public static void main(String[] args) {
        int[] arr={2,-1,3,-1,1,4,-2,-3,5,3,1};
        int target=3;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);

        int prev=0;

        int count=0;

        for(int i: arr){

            int val=prev+i;

            if(map.containsKey(val)){

                int v=map.get(val);
                map.put(val,v+1);

             

                


            }else{
                map.put(val,1);
            }
            int substract=val-target;

            if(map.containsKey(substract)){
                count+=map.get(substract);
           }

            prev=val;

            


            



        }

      //  System.out.println(map);
      // it have 7 subarray which have sum of 3
      // bruteforce would be generating all the subarrays 
      // then checking their sum
      // tc of bruteforce would be 0(n^3);

        System.out.println(count);





    }
    
}
