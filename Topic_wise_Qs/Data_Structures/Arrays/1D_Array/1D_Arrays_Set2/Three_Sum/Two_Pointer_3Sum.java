/* 
    LeetCode 15: 3Sum
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation: 
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

    Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

    Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.
*/

// TWO POINTER APPROACH

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Two_Pointer_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Create an empty list 'result' to store the triplets whose sum is zero:
        List<List<Integer>> result = new ArrayList<>();

        // Sort the Input Array:
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // Skip Duplicate Elements:
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            // Initialize Pointers:
            int j = i + 1; // j will initially point to the element next to the current element i
            int k = nums.length - 1; // k will initially point to the element at the end of the array

            // Two-Pointer Approach to find the triplets whose sum equals zero:
            while (j < k) {
                // Calculate the total sum of the current triplet
                int total = nums[i] + nums[j] + nums[k];

                // Adjust Pointers Based on Total:
                if (total > 0) {
                    /*
                     * If the total sum is greater than zero, decrement the k pointer to decrease
                     * the total sum.
                     */
                    k -= 1; // k--;
                } else if (total < 0) {
                    /*
                     * If the total sum is less than zero, increment the j pointer to increase the
                     * total sum.
                     */
                    j += 1; // j++;
                } else {
                    // If the total sum equals zero, add [nums[i], nums[j], nums[k]] to the result
                    // list
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Handle Duplicate Triplets:
                    /* Increment the j pointer to skip any duplicate elements. */
                    j++;
                    while ((nums[j] == nums[j - 1]) && (j < k)) {
                        j++;
                    }
                }
            }
        }

        return result;
    }
}