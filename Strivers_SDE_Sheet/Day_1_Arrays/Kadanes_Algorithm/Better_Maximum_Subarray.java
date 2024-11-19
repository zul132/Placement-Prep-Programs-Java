/* 
    BETTER SOLUTION:
    Given an integer array nums, find the subarray with the largest sum, and return its sum.

    Intuition: To get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the 
    sum of the previous subarray i.e. arr[i….j-1].

    Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]
    This is how we can remove the third loop and while moving j pointer, we can calculate the sum.

    Note: In Leetcode, this better solution passed 205/210 test cases only due to Time Limit Exceeded
*/
// Time Complexity: O(N^2), where N = size of the array.
// Space Complexity: O(1) as we are not using any extra space.

public class Better_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        // loop to select every possible starting index of the subarray
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // loop for the ending index as well as the current element of the subarray
            for (int j = i; j < n; j++) {
                // add the current element to the sum of the previous subarray
                // i.e. sum = sum + arr[j]
                sum += nums[j];

                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }
}
