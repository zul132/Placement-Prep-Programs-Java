// Time complexity: O(n)
// Space complexity: O(n)

public class Optimal_Subarray_Equals_K {
    public int subarraySum(int[] nums, int k) {
        // Initialize variables
        int sum = 0;
        int count = 0;
        // A map to store the frequency of cumulative sums, as we keep track of how many
        // times we see a particular sum.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Add an initial entry for sum 0 with frequency 1.
        // This is needed to handle cases where a subarray starting from the beginning
        // has a sum equal to k.
        map.put(0, 1);

        // Iterate through the array
        for (int n : nums) {
            sum += n;

            // Check if there exists a prefix sum such that removing it results in the
            // desired sum k.
            // This means we check if (sum - k) exists in the map.
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // Increment the count by the frequency of (sum - k).
            }

            // Update the frequency of the current cumulative sum in the map.
            // If the sum already exists, increment its frequency; otherwise, initialize it
            // to 1.
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count; // Return the total count of subarrays with sum equal to k.
    }

}
