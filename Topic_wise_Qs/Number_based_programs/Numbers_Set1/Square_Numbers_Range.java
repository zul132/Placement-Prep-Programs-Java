/* 
    Given two numbers a and b both we have to find the square numbers which lie between a and b(inclusive).

    Input Format:
    20
    100
    Output Format:
    25 36 49 64 81 100

    Sample Input 0:
    30
    90
    Sample Output 0:
    36 49 64 81
*/
// Asked in ZOHO interviews

import java.io.*;
import java.util.*;

public class Square_Numbers_Range {
    static void printSquares(int a, int b)
    {
        int x = (int)Math.ceil(Math.sqrt(a));
        int y = (int)Math.floor(Math.sqrt(b));
        
        for(int i=x; i<=y; i++)
            System.out.print((i*i) + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        printSquares(a,b);
    }
}
