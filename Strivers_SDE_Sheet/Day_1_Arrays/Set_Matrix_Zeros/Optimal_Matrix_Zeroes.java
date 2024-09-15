/* 
    Given an m x n integer matrix 'matrix', if an element is 0, set its entire row and column to 0's. 
*/

// Optimal Solution
/* 
    Time Complexity: O(2 * mn) 
                     => O(N^2) for a square matrix
    Space Complexity: O(1)
*/

import java.util.Scanner;

public class Optimal_Matrix_Zeroes {
    static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // int row[] = new int[m]; --> matrix[..][0]
        // int col[] = new int[n]; --> matrix[0][..]

        /*
         * For every 0 in matrix we mark it's corresponding row and column number as 0
         */
        int col0 = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // mark the i-th row
                    matrix[i][0] = 0;

                    // mark the j-th column
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // traverse the matrix excluding the first row and first column.
        /*
         * If the element is not 0 and its corresponding row or column number is
         * marked 0 then set it to Zero
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // check if element is not zero
                if (matrix[i][j] != 0) {
                    // check for column & row
                    if ((matrix[0][j] == 0) || (matrix[i][0] == 0))
                        matrix[i][j] = 0;
                }
            }
        }

        // Based on matrix[0][0], check if first row should be marked as Zero
        if (matrix[0][0] == 0) {
            for (int j = 1; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Based on col0, check if first column should be marked as Zero
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };

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
