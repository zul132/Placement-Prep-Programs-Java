/*
    Sara is interested so much in gardening and she plants more trees in her garden. She plants trees in a rectangular fashion with the 
    order of rows and columns. She numbered the trees in column wise order and planted mango tree only in a 1st row, 1st column and 
    last column. So given the tree number, write a program to find whether the given tree is a mango tree or not?

    EXAMPLE:
    5x5 sized garden will look like this:
                        1 6  11 16 21
                        2 7  12 17 22
                        3 8  13 18 23
                        4 9  14 19 24
                        5 10 15 20 25
    Sample Input 0:
    5
    5
    15
    Sample Output 0:
    No

    Sample Input 1:
    5
    5
    25
    Sample Output 1:
    Yes
*/

import java.io.*;
import java.util.*;

public class Mango_Tree_Challenge {
    public static boolean isMangoTree(int r, int c, int t) {
        // check first column
        if ((t >= 1) && (t <= r))
            return true;

        // check first row
        for (int i = 1; i <= r * c; i += r)
            if (t == i)
                return true;

        // check last column
        for (int i = 0; i < r; i++)
            if (t == ((r * c) - i))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int t = sc.nextInt();

        if (isMangoTree(r, c, t))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
