/*
    You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. 
    Return the wealth that the richest customer has.
    A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has 
    the maximum wealth.

    Example 2:
    Input: accounts = [[1,5],[7,3],[3,5]]
    Output: 10
    Explanation: 
    1st customer has wealth = 6
    2nd customer has wealth = 10 
    3rd customer has wealth = 8
    The 2nd customer is the richest with a wealth of 10.

    Example 3:
    Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
    Output: 17
*/
import java.util.Scanner;

class Richest_Customer_Wealth {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            if (wealth > max) {
                max = wealth;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] accounts = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                accounts[i][j] = sc.nextInt();

        // Print the richest customer's wealth
        System.out.println(maximumWealth(accounts));
    }
}