
/* 
    Program to sort an array of numbers using Insertion Sort.
*/
/* Time Complexity: O(n^2) (Worst,Average case)
                    O(n) (Best case) 
*/

import java.util.Scanner;

public class Insertion_Sort {
    static void insertionSort(int arr[], int n) {
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

        // input the array
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Sort the array using Insertion Sort
        insertionSort(arr, n);

        // print the sorted array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
