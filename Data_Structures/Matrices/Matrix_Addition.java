/* Program to perform matrix addition */

import java.util.Scanner;

public class Matrix_Addition {
    static int[][] addMatrices(int a[][], int b[][]) {
        int m = a.length;
        int n = a[0].length;
        int sum[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                sum[i][j] = a[i][j] + b[i][j];
        return sum;
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

        // compute the sum of two matrices
        if ((m1 != m2) || (n1 != n2)) {
            System.out.println("\nError: Orders must be equal for matrix addition");
        } else {
            int sum[][] = addMatrices(mat1, mat2);
            System.out.println("\nSum of the two matrices:");
            printMatrix(sum);
        }

    }
}