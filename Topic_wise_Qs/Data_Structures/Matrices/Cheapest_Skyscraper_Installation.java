
/* 
    Imagine that you want to install RTLS beacons on each floor of a skyscraper. You are looking for the cheapest installation but with 
    a restriction: in order to prevent radio waves interference, you should not use the same frequency beacons on the neighbour floors. 
    You have a price list for each floor and all available frequencies,

    Sample Input 0:
    4 3
    1 2 3
    1 2 1
    3 3 2
    4 1 2

    Sample Output 0:
    6
*/
import java.io.*;
import java.util.*;

public class Cheapest_Skyscraper_Installation {
    public static int getCheapestInstallation(int arr[][], int r, int c) {
        int res[][] = new int[r][c];

        // copy the first row
        for (int i = 0; i < c; i++)
            res[0][i] = arr[0][i];

        // fill the result table
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = Integer.MAX_VALUE;

                for (int k = 0; k < c; k++) {
                    if (j != k) {
                        res[i][j] = (int) Math.min(res[i][j], res[i - 1][k] + arr[i][j]);
                    }
                }
            }
        }

        /* To find the minimum cost in the last row */
        int min = res[r - 1][0];
        for (int i = 1; i < c; i++)
            if (res[r - 1][i] < min)
                min = res[r - 1][i];

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input the order of the matrix
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        int min_install = getCheapestInstallation(mat, m, n);
        System.out.println(min_install);

    }
}