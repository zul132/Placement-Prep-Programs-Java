/* 
    Program to sort an array of numbers using Bubble Sort. 
    Bubble sort is a Sorting Algorithm that compares two Adjacent elements and swaps them until all the elements are in their sorted order.

    After each iteration in bubble sort, the largest element among the unsorted elements is pushed to the end.
    In each iteration, the comparison takes place up to the last unsorted element.
*/
// Time Complexity (Worst,Average): O(n2)
// Best Time Complexity: O(n) --> array is already sorted
// Space Complexity: O(1)
/*  
    Optimized Bubble Sort: we add a boolean flag 'swapped' to check if swapping has occurred at the end of each iteration.
    If no swapping occurred then it means the array is now sorted, so need for further comparisons.
*/

import java.util.Scanner;

public class Bubble_Sort {
    static void bubbleSort(int arr[], int n) {
        // loop to access each array element
        for (int i = 0; i < n - 1; i++) {
            // Flag to check if swapping occurs
            boolean swapped = false;

            // loop to compare array elements
            for (int j = 0; j < n - i - 1; j++) {
                // compare two adjacent elements
                if (arr[j] > arr[j + 1]) {
                    /* Swap if adjacent elements are not in the sorted order */
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }
            // no swapping means the array is already sorted
            // so no need for further comparison
            if (!swapped)
                break;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of the array

        // input the array
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Sort the array using Bubble Sort
        bubbleSort(arr, n);
        // print the sorted array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

}
