/* Given an array of random numbers, Push all the zero’s of the given array to the end of the array.
 * APPROACH 1:
*/
/* Companies asked: MultiCoreWare, SAP Labs, Amazon, Bloomberg, LinkedIn (Interview round mostly)*/

//Time Complexity: O(n) where n is the number of elements of the input array.
//Auxiliary Space: O(1)

import java.util.Scanner;

public class Move_All_Zeros_To_End_Array {
    static void pushZerosToEnd(int arr[], int n) {
        int count = 0;

        // Traverse the array. If element encountered is non-
        // zero, then replace the element at index 'count'
        // with this element and increment 'count'.
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count += 1;
            }
        }

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n) {
            arr[count++] = 0;
        }
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
