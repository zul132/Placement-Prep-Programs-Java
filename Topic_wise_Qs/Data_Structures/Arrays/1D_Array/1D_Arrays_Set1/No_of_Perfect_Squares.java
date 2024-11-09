/* 
    Program to find the number of perfect square numbers in an array of numbers.

    Sample Input 0: arr = [1, 4, 16, 20, 25, 30]
    Sample Output 0: 4

    Sample Input 1: arr = [3, 8, 15, 17, 24, 31]
    Sample Output 1: 0
*/
// Companies asked: SAP Labs (Coding round)

import java.util.Scanner;

public class No_of_Perfect_Squares {
    static boolean isPerfectSquare(int x) {
        // Check whether the square root of x is a integer or not
        if (Math.sqrt(x) == Math.floor(Math.sqrt(x)))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of the array

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Count the no of perfect squares in the array
        int count = 0;
        for (int i = 0; i < n; i++)
            if (isPerfectSquare(arr[i]) && arr[i] >= 0)
                count++;

        System.out.println("Number of perfect square numbers is " + count);
    }
}
