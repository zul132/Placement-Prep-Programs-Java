/* Program to perform Matrix Multiplication on two given matrices */

import java.util.Scanner;

public class Matrix_Multiplication {
    static int[][] multiplyMatrices(int a[][], int b[][]) {
        int m = a.length;
        int n = b.length; // =a[0].length
        int p = b[0].length;
        int res[][] = new int[m][p];

        return res;
    }

    static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input matrix 1
        int m1 = sc.nextInt();
        int n1 = sc.nextInt();
        int mat1[][] = new int[m1][n1];

        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n1; j++)
                mat1[i][j] = sc.nextInt();

        System.out.println("\nMatrix 1:");
        printMatrix(mat1);
        System.out.println();

        // Input matrix 2
        int m2 = sc.nextInt();
        int n2 = sc.nextInt();
        int mat2[][] = new int[m2][n2];

        for (int i = 0; i < m2; i++)
            for (int j = 0; j < n2; j++)
                mat2[i][j] = sc.nextInt();

        System.out.println("\nMatrix 2:");
        printMatrix(mat2);

        // Multiply the two matrices
        if (n1 == m2) {
            int result[][] = multiplyMatrices(mat1, mat2);
            System.out.println("\nProduct of the two matrices:");
            printMatrix(result);
        } else {
            System.out.println(
                    "\nError: Number of columns in the First matrix must be equal to Number of rows in the Second matrix to perform matrix multiplication.");
        }

    }
}
