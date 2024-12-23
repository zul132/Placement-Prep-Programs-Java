/* 
    Program to find the given element in array using Linear Search.

    Time Complexity: O(n)
*/

import java.util.Scanner;

public class Linear_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of the array

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int x = sc.nextInt(); // element to search
        int flag = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] == x) {
                System.out.println("Element found at index " + (i + 1));
                flag = 1;
                break;
            }

        if (flag == 0)
            System.out.println("Element not found in the array!");
    }
}
