/* 
    Program to sort an array of numbers using Selection Sort.

    Selection sort is an in-place soring algorithm that selects the smallest element from an unsorted list 
    in each iteration and places that element at the beginning of the unsorted list.

    In each iteration, we are finding the minimum of the unsorted elements and placing it at the beginning of the unsorted list
*/
// Time Complexity: O(n^2)

import java.util.Scanner;

public class Selection_Sort {
    static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            // Select the minimum element in each iteration
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }

            // Swap to put min in its correct position (i.e. at the beginning)
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of the array

        // input the array
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Sort the array using Selection Sort
        selectionSort(arr, n);

        // print the sorted array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
