/* Write a program to check if the given number is Armstrong or not.
   Input 0: 153
   Output 0: Armstrong Number

   Input 1: 155
   Output 1: Not an Armstrong Number
 */

import java.io.*;
import java.util.*;

public class Check_Armstrong_Number_1 {
    public static boolean isArmstrong(int num) {
        int sum = 0, r;
        int q = num;
        int n = count(num); // count of digits in num

        while (q > 0) {
            r = q % 10;
            sum = sum + pow(r, n);
            // sum = sum + (int) Math.pow(r, n);
            q = q / 10;
        }

        if (sum == num)
            return true;
        else
            return false;
    }

    // utility function to find the count of digits in a number
    public static int count(int n) {
        int x = 0;
        while (n != 0) {
            n /= 10;
            x++;
        }
        return x;
    }

    // utility function to find the power/exponent of A raised to B
    public static int pow(int a, int b) {
        int res = a;
        for (int i = 1; i < b; i++) {
            res *= a;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isArmstrong(n))
            System.out.println("Armstrong Number");
        else
            System.out.println("Not an Armstrong Number");
    }

}
