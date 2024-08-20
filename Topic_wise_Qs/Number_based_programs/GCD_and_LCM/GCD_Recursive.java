/* Recursive Solution for finding GCD by using Euclidean algorithm with Modulo operator */
//Time complexity: O(log(min(a,b))

import java.util.Scanner;

public class GCD_Recursive {
    static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(GCD(A, B));
        sc.close();
    }
}
