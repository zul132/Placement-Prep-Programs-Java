/*
    You’re given an array. Print the elements of the array which are greater than all its
    previous elements in the array.

    Input Format:
    7
    2 -3 -4 5 9 7 8
    Output Format:
    2 5 9
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Greater_than_Prev_Elements {
    public static void printGreater(ArrayList<Integer> arr) {
        System.out.print(arr.get(0) + " ");

        for (int i = 1; i < arr.size(); i++) {
            int flag = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(i) < arr.get(j)) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.print(arr.get(i) + " ");

        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        printGreater(arr);
    }
}