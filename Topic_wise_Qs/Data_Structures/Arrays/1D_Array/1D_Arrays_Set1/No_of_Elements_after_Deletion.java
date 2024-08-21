/* 
    Given an array of numbers 'nums' and a number 'x', write a program to return the number of elements in 'nums' 
    after removing all occurances of 'x'.

    Input:
    nums = [3,4,6,3,7,9,3,5]
    x = 2
    Output:
    5
*/
// Companies asked: Sagent (short coding assessment)

import java.util.Scanner;

public class No_of_Elements_after_Deletion {
    static int getSizeAfterRemoval(int arr[], int n, int x) {
        int newSize = n;
        // for every occurance of x (if any) decrement newSize
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                newSize--;

        return newSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input the size of the array
        int n = sc.nextInt();

        // create the array and input the array elements
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // get the number to be removed
        int x = sc.nextInt();

        // print the number of elements after removing all occurances of 'x'
        System.out.println(getSizeAfterRemoval(nums, n, x));
    }
}
