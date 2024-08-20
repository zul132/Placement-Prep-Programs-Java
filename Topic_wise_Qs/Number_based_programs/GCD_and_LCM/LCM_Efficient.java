/* Efficient Solution to find the LCM of two numbers by using GCD */
//Time complexity: O(log(min(a,b))
//Auxiliary Space: O(log(min(a,b))

import java.util.Scanner;

public class LCM_Efficient {

    // Recursive method to return gcd of a and b
    static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    static int LCM(int a, int b) {
        return ((a / GCD(a, b) * b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(LCM(A, B));
        sc.close();
    }
}
