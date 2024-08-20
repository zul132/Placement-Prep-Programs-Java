/* 
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

    Example 2:
    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]
*/
import java.util.Scanner;

class Running_Sum_1D_Array {
    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] running = new int[n];
        running[0] = nums[0];
        for (int i = 1; i < n; i++) {
            running[i] = running[i - 1] + nums[i];
        }
        return running;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result[] = runningSum(arr);
        for (int i = 0; i < n; i++)
            System.out.print(result[i] + " ");
    }
}