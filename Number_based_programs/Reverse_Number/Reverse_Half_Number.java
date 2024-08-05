import java.io.*;
import java.util.*;

public class Reverse_Half_Number {
    static int count(int n) {
        int x = 0;
        while (n != 0) {
            n /= 10;
            x++;
        }
        return x;
    }

    static int pow(int a, int b) {
        int s = 1;
        for (int i = 1; i <= b; i++) {
            s *= a;
        }
        return s;
    }

    static int revHalf(int n) {
        int len = count(n);
        int rev = 0, q, r, x;
        if (len % 2 == 0) {
            x = 0; // even length number
        } else {
            x = -1; // odd length number
        }
        q = n;
        while (q != 0 && x != len / 2) {
            r = q % 10;
            rev = rev * 10 + r;
            q /= 10;
            x = x + 1;
        }
        if (len % 2 != 0) { // in case of odd length
            x = x + 1;
        }
        return q * pow(10, 3) + rev;
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(revHalf(n));

    }
}