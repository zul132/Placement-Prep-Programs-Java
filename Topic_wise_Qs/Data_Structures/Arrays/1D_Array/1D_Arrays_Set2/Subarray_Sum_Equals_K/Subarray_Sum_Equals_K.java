/* 
    Leetcode 560. Subarray Sum Equals K
    Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
    
    A subarray is a contiguous non-empty sequence of elements within an array.

    Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2

    Example 2:
    Input: nums = [1,2,3], k = 3
    Output: 2
*/
// Time complexity: O(n^2)
// Space complexity: O(1)

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // initialize subarray sum starting at index i
            int sum = nums[i];
            if (sum == k) // if element itself equal to k, then also increment count
                count++;

            for (int j = i + 1; j < n; j++) {
                sum += nums[j];

                // if at any point sum becomes equal to k, increment count
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;

    }
}
