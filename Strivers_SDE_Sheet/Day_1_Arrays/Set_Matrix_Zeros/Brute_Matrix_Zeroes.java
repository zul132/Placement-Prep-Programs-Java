/* 
    Given an m x n integer matrix 'matrix', if an element is 0, set its entire row and column to 0's. 

    EXAMPLE 1:
    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[1,0,1],[0,0,0],[1,0,1]]

    EXAMPLE 2:
    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/

// Brute Force Solution
/* 
    Time Complexity: O(mn) * O(m + n) + O(mn)
                     => O(N^3) for a square matrix
    Space Complexity: O(1)
*/

import java.util.Scanner;

public class Brute_Matrix_Zeroes {
    static void setZeroes(int[][] arr) {
        int m = arr.length; // no of rows
        int n = arr[0].length; // no of columns

        // To find all the zero elements and set their corresponding non-zero row/column
        // elements to -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (arr[i][j] == 0) {
                    markRow(arr, i, n);
                    markCol(arr, j, m);
                }
        }

        // Now set all -1 elements to zero
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (arr[i][j] == -1)
                    arr[i][j] = 0;

    }

    /* Function to set all non-zero elements of Row i as -1 */
    static void markRow(int[][] arr, int i, int n) {
        for (int j = 0; j < n; j++)
            if (arr[i][j] != 0)
                arr[i][j] = -1;
    }

    /* Function to set all non-zero elements of Column j as -1 */
    static void markCol(int[][] arr, int j, int m) {
        for (int i = 0; i < m; i++)
            if (arr[i][j] != 0)
                arr[i][j] = -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = { { 1, 1, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 } };

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
