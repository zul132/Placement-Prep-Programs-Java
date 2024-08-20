/* Given an array of random numbers, Push all the zero’s of the given array to the end of the array. 
 * APPROACH 2: Partioning the Array
*/
//Time Complexity: O(n) where n is the number of elements of the input array.
//Auxiliary Space: O(1)

import java.util.Scanner;

public class Partitioning_Array_Method {
    static void pushZerosToEnd(int arr[], int n) {
        int j = 0; // Pivot element index

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                swap(arr, j, i); // Partion the array
                j++;
            }
        }
    }

    // utility functiom to swap two elements of an array
    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of array

        // Input the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        pushZerosToEnd(arr, n);

        // print the array after pushing all zeros to the end
        System.out.println("Array after pushing all zeros to the end:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
