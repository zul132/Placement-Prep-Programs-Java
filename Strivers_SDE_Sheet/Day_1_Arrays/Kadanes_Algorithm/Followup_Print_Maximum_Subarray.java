/* 
    Follow-up question: Interviewer might ask - Can you print the subarray with the maximum sum?

    INTUITION:
    There might be more than one subarray with the maximum sum. We need to print any of them. 
    Our approach is to store the starting index and the ending index of the subarray. Thus we can easily 
    get the subarray afterward without actually storing the subarray elements.

    Note: Whenever the sum becomes 0, it means we are starting a new subarray and the subarray ends when sum becomes > maxSum.
*/

public class Followup_Print_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        int sum = 0, start = -1;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {
            /* Subarray always starts at the index where the sum variable is equal to 0 */
            if (sum == 0)
                start = i;

            sum += nums[i];
            // At the ending index, the sum always crosses the previous maximum sum
            if (sum > maxSum) {
                maxSum = sum;
                /*
                 * when the sum crosses the maximum sum, we will set ansStart to the start
                 * variable and ansEnd to the current index i.e. i.
                 */
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0)
                sum = 0;
        }

        // Print the subarray with the maximum sum
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }

        return maxSum;
    }
}
