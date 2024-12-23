/* 
    Iterative program to implement Binary Search (i.e. using loops).
*/

import java.util.Scanner;

public class Binear_Search_Iterative {
    // helper function to sort the array using Insertion Sort
    static void sort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int k = arr[i]; // current key
            int j = i - 1;

            while ((j >= 0) && (arr[j] > k)) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of the array

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int x = sc.nextInt(); // element to search
        /*
         * for Binary Search, array needs to be in sorted order
         */
        sort(arr, n);

        // Print the sorted array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        int flag = 0;
        int start = 0;
        int stop = n - 1;
        int mid = (start + stop) / 2;
        while (start <= stop) {
            if (x > arr[mid])
                start = mid + 1;
            else if (x < arr[mid])
                stop = mid - 1;
            else {
                System.out.println("Element found at index " + (mid + 1));
                flag = 1;
                break;
            }
            mid = (start + stop) / 2;
        }

        if (flag == 0)
            System.out.println("Element not found in the array!");
    }
}
