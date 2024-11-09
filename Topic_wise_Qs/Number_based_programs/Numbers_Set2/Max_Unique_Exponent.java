/* 
    Write a program to find the integer within a given range [a, b] (inclusive) that has the highest count of prime factors, 
    including multiplicities. If multiple numbers within this range have the same maximum count of prime factors, 
    the program should return the smallest number with this count. The program should output two values: 
    the maximum count of prime factors 'mx' and the corresponding integer 'ans'.

    Sample Input 0: 10 15
    Sample Output 0: 
    3
    12
    Explanation:
    For the range [10, 15]:
    10 has 2 prime factors (2, 5).
    11 has 1 prime factor (11).
    12 has 3 prime factors (2, 2, 3).
    13 has 1 prime factor (13).
    14 has 2 prime factors (2, 7).
    15 has 2 prime factors (3, 5).
    Among these, 12 has the highest count of prime factors (3), so the output is 3 and 12.

    Sample Input: 2 10
    Sample Output: 
    3 
    8
    Explanation:
    Between 2 and 10, the integer 8 has the most prime factor divisions (with a total of 3: 8=2×2×2), 
    so the output is 3 for the count and 8 for the integer.
*/
// Companies asked: SAP Labs (Coding Round)

import java.util.Scanner;

public class Max_Unique_Exponent {
    static int mx = 0;
    static int ans = 0;

    static void maxCountPrimeFactors(int n) {
        int c = 0;
        int k = n;
        // Count the prime factors of input n
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                c++;
            }
        }
        // If count c > mx, set mx as c, and ans as k
        if (c > mx) {
            mx = c;
            ans = k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = a; i <= b; i++)
            maxCountPrimeFactors(i);
        System.out.println(mx + "\n" + ans);
    }

}
