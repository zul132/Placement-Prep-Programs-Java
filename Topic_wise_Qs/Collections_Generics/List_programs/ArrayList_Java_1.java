
/* 
    You are given n lines. In each line there are zero or more integers. You need to answer a few queries 
    where you need to tell the number located in yth position of xth line.

    Input Format
    The first line has an integer n. In each of the next n lines there will be an integer d denoting number of integers on that line 
    and then there will be d space-separated integers. In the next line there will be an integer q denoting number of queries. 
    Each query will consist of two integers x and y.

    Sample Input:
    5
    5 41 77 74 22 44
    1 12
    4 37 34 36 52
    0
    3 20 22 33
    5
    1 3
    3 4
    3 1
    4 3
    5 5
    
    Sample Output:
    74
    52
    37
    ERROR!
    ERROR!
*/
import java.io.*;
import java.util.*;

public class ArrayList_Java_1 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer[]> lines = new ArrayList<>(n);

        int d;
        for (int i = 0; i < n; i++) {
            d = sc.nextInt();
            Integer[] line = new Integer[d];
            for (int j = 0; j < d; j++) {
                line[j] = sc.nextInt();
            }
            lines.add(line);
        }

        int q = sc.nextInt();
        int x, y;
        for (int i = 0; i < q; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            Integer[] line = lines.get(x - 1);
            try {
                System.out.println(line[y - 1]);
            } catch (IndexOutOfBoundsException E) {
                System.out.println("ERROR!");
            }
        }
    }
}
