/* 
    Given an m x n integer matrix 'matrix', if an element is 0, set its entire row and column to 0's. 
*/

// Better Solution (still Brute Force)
/* 
    Time Complexity: O(2 * mn) 
                     => O(N^2) for a square matrix
    Space Complexity: O(m+n) = O(m) + O(n)
*/

import java.util.Scanner;

public class Better_Matrix_Zeroes {
    static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // create 2 arrays to keep track of the rows and columns to be changed
        int row[] = new int[m];
        int col[] = new int[n];

        /*
         * For every zero in matrix we mark it's corresponding row and column value as 1
         * in the arrays
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        /*
         * For each element, check if it's corresponding row or column array value is 1.
         * If yes, then change that element to Zero
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] == 1) || (col[j] == 1))
                    matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 0, 0, 1 } };

        // call set Matrix Zeroes method
        setZeroes(mat);

        // print the matrix after setting zeroes
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}
