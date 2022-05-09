public class base {
    public static void main(String[] args) {

        int out=anyBaseToanyBase(your_number,2,6);
        System.out.println(out);


        
    }

    public static int decimalToanyBase(int n, int b) {
        int pow=1;
        int ans=0;
        while(n>0){
            int rem=n%b;
            ans+=rem*pow;
            pow=pow*10;
 
            n=n/b;
 
 
 
 
 
        }
 
        return ans;
 
 
 
       
     }
 
     // 1 < b <= 10
     public static int anyBaseToDecimal(int n, int b) {
         int pow=1;
         int ans=0;
 
         
         while(n>0){
             int rem=n%10;
             ans+=rem*pow;
             pow=pow*b;
 
             n=n/10;
 
 
 
 
 
         }
 
         return ans;
     }
 
 
     public static int anyBaseToanyBase(int n, int b1, int b2) {
         int decimal = anyBaseToDecimal(n, b1);
         int ans = decimalToanyBase(decimal, b2);
 
         return ans;
     }
}