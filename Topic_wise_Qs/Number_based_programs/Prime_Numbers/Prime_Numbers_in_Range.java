/* Program to print all the prime numbers in a range.
   Input: 10 20
   Output: 11 13 17 19
 */

import java.io.*;
import java.util.*;

public class Prime_Numbers_in_Range {
    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        else {
            for (int i = 3; i < n; i += 2) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = a; i < b; i++) {
            if (isPrime(i))
                System.out.print(i + " ");
        }
    }
}
