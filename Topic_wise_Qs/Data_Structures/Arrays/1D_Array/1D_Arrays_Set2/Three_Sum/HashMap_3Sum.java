/*
    LeetCode 15: 3Sum - HashMap Approach

    As array may have both -ve and +ve numbers, firstly we sort the array. 

    Base cases after sorting:
    1 - If array size is < 3, means no triplet would exist from that array. Return empty vector of vectors.
    2 - If first element is +ve, that means there is no -ve number by which we can make a 0 triplet sum. Return empty vector of vectors.

    IMP NOTE: This approach is not that optimal as it uses extra space for HashMap. The optimal approach is Two Pointer approach.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMap_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the input array in an increasing order
        Arrays.sort(nums);

        if (nums.length < 3) { // Base Case 1
            return new ArrayList<>();
        }
        if (nums[0] > 0) { // Base Case 2
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        /*
         * Hash the indices of all elements in a HashMap.
         * In case of repeated elements, the last occurence index would be stored in
         * hashMap.
         */
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        // Traverse to fix the first number
        for (int i = 0; i < nums.length - 2; i++) {
            /*
             * If number fixed is +ve, stop there because we can't make the triplet sum zero
             * by searching after it.
             */
            if (nums[i] > 0) {
                break;
            }

            // Fix the second number
            for (int j = i + 1; j < nums.length - 1; j++) {
                // To make triplet sum 0, we would require the -ve sum of both fixed numbers.
                int required = -(nums[i] + nums[j]);

                // if required exists in hashmap, and its last occurrence index > 2nd fixed
                // index, we found our triplet.
                if (hashMap.containsKey(required) && (hashMap.get(required) > j)) {
                    result.add(Arrays.asList(nums[i], nums[j], required));
                }

                // Update j to last occurence of 2nd fixed number to avoid duplicate triplets.
                j = hashMap.get(nums[j]);
            }
            // Update i to last occurence of 1st fixed number to avoid duplicate triplets.
            i = hashMap.get(nums[i]);
        }

        return result;
    }
}
