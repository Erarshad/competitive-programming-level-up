import java.util.ArrayList;
import java.util.Scanner;

public class t{
   public static void main(String... args){
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();// slots
      int m=sc.nextInt();
      ArrayList<Integer>[]  mat=new ArrayList[n];
      for(int i=0;i<n;i++){
         mat[i]=new ArrayList<>();
      }
     int k=0;
      for(int i=0;i<n;i++){
         k=sc.nextInt();
         for(int j=0;j<k;j++){
            mat[i].add(sc.nextInt());
         }
      }
      //----------------------------------------------

      int max=Integer.MIN_VALUE;

      for(int i=0;i<n;i++){



         
     


            

         


      }


     





       
   }

   


   private int LIS1_tabu(ArrayList<Integer>arr, int[] dp) {

      int maxLength = 0;
      for (int i = 0; i < arr.size(); i++) {
          int maxLen = 1;
          for (int j = i - 1; j >= 0; j--) {
              if (arr.get(i) > arr[j]) {
                  int len = dp[j];
                  maxLen = Math.max(maxLen, len + 1);
              }
          }
          dp[i] = maxLen;
          maxLength = Math.max(maxLength, maxLen);
      }
      return maxLength;
  }
  private int LDS3_tabu(int[] arr, int[] dp) {

   int maxLength = 0;
   int n = arr.length;
   for (int i = n - 1; i >= 0; i--) {
       int maxLen = 1;
       for (int j = i + 1; j < n; j++) {
           if (arr[i] > arr[j]) {
               int len = dp[j];
               maxLen = Math.max(maxLen, len + 1);
           }
       }
       dp[i] = maxLen;
       maxLength = Math.max(maxLength, maxLen);
   }
   return maxLength;
}
private int LDS2_tabu(int[] arr, int[] dp) {

   int maxLength = 0;
   for (int i = 0; i < arr.length; i++) {
       int maxLen = 1;
       for (int j = i - 1; j >= 0; j--) {
           if (arr[i] < arr[j]) {
               int len = dp[j];
               maxLen = Math.max(maxLen, len + 1);
           }
       }
       dp[i] = maxLen;
       maxLength = Math.max(maxLength, maxLen);
   }
   return maxLength;
}
private int LIS4_tabu(int[] arr, int[] dp) {

   int maxLength = 0;
   int n = arr.length;
   for (int i = n - 1; i >= 0; i--) {
       int maxLen = 1;
       for (int j = i + 1; j < n; j++) {
           if (arr[i] < arr[j]) {
               int len = dp[j];
               maxLen = Math.max(maxLen, len + 1);
           }
       }
       dp[i] = maxLen;
       maxLength = Math.max(maxLength, maxLen);
   }
   return maxLength;
}



    
}