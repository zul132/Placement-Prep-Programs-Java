/*
    An hourglass in a matrix is typically defined as a subset of values that form an hourglass shape. Consider a 2D matrix (or grid) with 
    dimensions of at least 3x3. The hourglass pattern in such a grid is defined by the following positions:

                                                a b c
                                                  d
                                                e f g

    Given this, the maximum sum of an hourglass in a matrix involves finding the hourglass within the matrix that has the 
    largest sum of its elements. Return -1 if it is an invalid matrix.

    Sample Input 0:
    6 5
    1 1 1 0 0
    0 1 0 0 0
    1 1 1 0 0
    0 0 2 4 4
    0 0 0 2 0
    0 0 1 2 4
    Sample Output 0:
    19
*/

import java.io.*;
import java.util.*;

public class Max_Sum_Hourglass {
    public static int maxSumHourglass(int m[][], int r, int c) {
        if ((r < 3) || (c < 3))
            return -1;

        int max = 0;
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                int sum = m[i][j] + m[i][j + 1] + m[i][j + 2] + m[i + 1][j + 1] + m[i + 2][j] + m[i + 2][j + 1]
                        + m[i + 2][j + 2];

                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int mat[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        System.out.println(maxSumHourglass(mat, m, n));
    }
}