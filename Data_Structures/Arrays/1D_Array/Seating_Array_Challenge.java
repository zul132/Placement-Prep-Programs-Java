/*
    Have the function ArrayChallenge (arr) read the array of integers stored in arr which will be in the following format: 
    [K, r1, r2, r3, ...] where K represents the number of desks in a classroom, and the rest of the integers in the array will be 
    in Sorted order and will represent the desks that are already occupied. All of the desks will be arranged in 2 columns, 
    where desk #1 is at the top left, desk #2 is at the top right, desk #3 is below #1, desk #4 is below #2, etc. 

    Your program should return the number of ways 2 new students can be seated next to each other. This means 1 student is on the left 
    and 1 student on the right, or 1 student is directly above or below the other student.

    Note: K will range from 2 to 24 and will always be an even number.

    Sample Input 0:
    3
    8 1 8
    Sample Output 0:
    6

    Sample Input 1:
    5
    12 2 6 7 11
    Sample Output 1:
    6
*/

import java.io.*;
import java.util.*;

public class Seating_Array_Challenge {
    static int ArrayChallenge(int a[]) {
        int arr[] = new int[a[0] + 1];

        // mark the occupied seats
        for (int i = 1; i < a.length; i++)
            arr[a[i]] = 1;

        int count = 0;
        int n = arr.length - 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == 0) // if current seat is free
            {
                // for even desk check the next even desk
                if ((i % 2 == 0) && (arr[i + 2] == 0)) {
                    count += 1;
                }

                // for odd desk check the seat next to it and the seat below
                if (i % 2 != 0) {
                    if (arr[i + 1] == 0)
                        count += 1;
                    if ((i != n - 1) && (arr[i + 2] == 0))
                        count += 1;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(ArrayChallenge(arr));
    }
}