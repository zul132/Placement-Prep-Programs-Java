/* 
    Leetcode 152: Maximum Product Subarray
    Given an integer array nums, find a subarray that has the largest product, and return the product.

    Example 1:
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

    Example 2:
    Input: nums = [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

    Pattern used: Kadane's algorithm
    Here we use a dynamic programming (DP) approach with two variables to efficiently handle the product variations 
    caused by negative numbers.
*/
// Time Complexity: O(N)
// Space Complexity: O(1)

public class MaxProductSubarray {
    public int maxProductSubarray(int[] nums) {
        int globalMax = nums[0], maxProduct = nums[0], minProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = Math.max(num, Math.max(num * maxProduct, num * minProduct));
            minProduct = Math.min(num, Math.min(num * maxProduct, num * minProduct));

            maxProduct = tempMax;
            globalMax = Math.max(globalMax, maxProduct);
        }

        return globalMax;
    }
}
