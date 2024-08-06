
/* 
   Sum the given input till it becomes single digit. In the given input 782, if you process sum of the digit 2+8+7=17.
   Here 17 is not a single digit, so again you need to process sum of the digit with 17 instead of 782, 7+1=8. 
   Here 8 is a single digit.Now we have to stop the process. 
   
   Input 0: 483256
   Output 0: 1
*/
import java.io.*;
import java.util.*;

public class Sum_till_Single_Digit_1 {
    public static int sum(int n) {
        int sum = 0, r;
        int q = n;
        while (q > 0) {
            r = q % 10;
            sum += r;
            q = q / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int s = sum(n);
        while (s > 9) {
            s = sum(s);
        }
        System.out.println(s);
    }
}
