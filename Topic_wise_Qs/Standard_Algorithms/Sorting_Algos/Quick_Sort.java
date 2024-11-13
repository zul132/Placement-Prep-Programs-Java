/* 
    Program to sort an array of numbers using Quick Sort.
    Key concepts in Quick sort --> Divide and Conquer, Recursion and Pivot. 

    Sample Input 0: {2, 3, 7, 6, 5}
    Sample Output 0: 2 3 5 6 7

    Sample Input 1: {5, 6, 2, 3, 1, 8, 4}
    Sample Output 1: {1, 2, 3, 4, 5, 6, 8}
*/
/* Time Complexity: O(nlogn) (Best,Average case)
                    O(n^2) (Worst case) 
*/

import java.util.Scanner;

public class Quick_Sort {
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        // Here we are taking last element as the Pivot
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap(arr[i], arr[j]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap(arr[i+1], arr[high]);
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the new pivot
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of the array

        // input the array
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Sort the array using Quick Sort
        quickSort(arr, 0, n - 1);

        // print the sorted array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
