/* 
    Leetcode 3689. Maximum Total Subarray Value I
    You are given an integer array nums of length n and an integer k.

    You need to choose exactly k non-empty subarrays nums[l..r] of nums. Subarrays may overlap, 
    and the exact same subarray (same l and r) can be chosen more than once.

    The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).

    The total value is the sum of the values of all chosen subarrays.

    Return the maximum possible total value you can achieve.

    Example 1:
    Input: nums = [1,3,2], k = 2
    Output: 4

    Example 2:
    Input: nums = [4,2,5,1], k = 3
    Output: 12    

    Intuition:
    Since we can choose the same subarray multiple times, we just need to find the maximum and minimum values in the whole array. 
    Find the difference between the maximum and minimum values, and multiply it by k to get the result.
*/
// Time Complexity: O(n) where n is the length of the input array nums
// Space Complexity: O(1) 

public class Maximum_Total_Subarray_Value {
    public long maxTotalValue(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }

        // Cast one of the operands to long to ensure the multiplication is performed
        // using long arithmetic
        return (long) k * (maxVal - minVal);
    }
}
