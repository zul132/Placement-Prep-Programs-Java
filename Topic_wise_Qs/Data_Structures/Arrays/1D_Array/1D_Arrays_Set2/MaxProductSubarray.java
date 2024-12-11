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

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0], currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // compute the maximum and minimum products for the current element.
            int tempMaxProduct = currentMax * num;
            int tempMinProduct = currentMin * num;

            /*
             * determine the current max product and current min product ending at the index
             * i
             */
            currentMax = Math.max(num, Math.max(tempMaxProduct, tempMinProduct));
            currentMin = Math.min(num, Math.min(tempMaxProduct, tempMinProduct));
            // find the global maximum product
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
}
