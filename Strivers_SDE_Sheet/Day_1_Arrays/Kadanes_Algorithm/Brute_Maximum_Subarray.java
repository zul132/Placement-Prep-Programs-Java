/* 
    Kadane's Algorithm : Maximum Subarray Sum in an Array
    Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
    has the largest sum and returns its sum.

    BRUTE FORCE SOLUTION:
    In Leetcode, the brute force solution passed 200/210 test cases only due to Time Limit Exceeded

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    Example 2:
    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.

    Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/
/* 
    Time Complexity: O(N^3), where N = size of the array.
    Reason: We are using three nested loops, each running approximately N times.

    Space Complexity: O(1) as we are not using any extra space.
 */

public class Brute_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        // loop to select every possible starting index of the subarray
        for (int i = 0; i < n; i++) {
            // loop to select every possible ending index of the subarray
            for (int j = i; j < n; j++) {
                int sum = 0;
                /* sum the elements of the subarray from index i to index j, i.e. nums[i..j] */
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                // check if the current subarray's sum is > maxSum
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }
}
