/* 
    Program to find the subarray of contiguous array elements which has the maximum sum and return its sum.

    Input 0:
    arr = [1, 2, 3, 4, - 6, 5]
    Output 0:
    10

    Input 1:
    arr = [-1, -2, -3, -4, -5]
    Output 0:
    -1

*/
// Companies asked: Sagent (tech interview)

import java.util.Scanner;

public class Max_Sum_Contiguous_Subarray {
    static int maxSumContiguous(int arr[], int n) {
        int maxSum = -999;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // print the maximum sum of subarray of continguous elements.
        System.out.println(maxSumContiguous(arr, n));
    }
}
