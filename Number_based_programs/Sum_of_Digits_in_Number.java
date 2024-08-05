/* Need to write a program to find out the sum of digit of number. */
/* Input 1: 1234
Output 2: 10

Input 2: 4567
Output 2: 22
*/
import java.io.*;
import java.util.*;

public class Sum_of_Digits_in_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0, r;
        int q = n;
        while (q > 0) {
            r = q % 10;
            sum += r;
            q = q / 10;
        }

        System.out.println(sum);
    }
}
