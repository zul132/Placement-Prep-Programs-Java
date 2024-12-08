/* 
    Note: We will be using Kadane's algorithm for the optimal solution.
    
    INTUITION: 
    If we get a negative sum at any point, it doesn't make sense to carry that sum forwrad to the next element, 
    because a negative subarray sum will ALWAYS REDUCE the value of the next sum (regardless of whether the next element is +ve or -ve)

    Example: {-2,-3,5}
        1st iteration: sum = -2, max = -2
        2nd iteration: 
        if we set sum = -2 + (-3) = -5, this value is smaller than {-3} on its own.
        Since it doesn't make sense to carry sum = -2 forward to the next iteration, we can just set sum = 0. 
        So sum = 0 + (-3) = -3, max = -2 (since -3 < -2)


    The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0. 
    A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the 
    subarray with maximum sum.

    Input: {-2, -3, 4, -1, -2, 1, 5, -3}
    Output: 7
    Explanation: 
    maximum sum subarray = {4, -1, -2, 1, 5}, which gives a sum of 7.

    NOTE: When you follow this approach, there is a possibilty of getting -ve sum, which might be a problem IF the question explicitly 
    says to consider the sum of the empty subarray (which is 0).
    
    So, in these cases, before returning the answer we will compare the maximum subarray sum calculated with 0(i.e. The sum of an 
    empty subarray is 0). And after that, we will return the maximum one.
    For e.g. if the given array is {-1, -4, -5}, the answer will be 0 instead of -1 in this case. 

*/
// Time Complexity: O(N), where N = size of the array.
// Space Complexity: O(1) as we are not using any extra space.

public class Optimal_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        // we use a single loop to iterate through the array
        for (int i = 0; i < n; i++) {
            // While moving i, Keep adding the next element
            sum += nums[i];
            if (sum > maxSum)
                maxSum = sum;

            // Discard the sum if it becomes negative (sum < 0)
            if (sum < 0)
                sum = 0;
        }

        // In case, question says to consider sum of the empty subarray
        /*
         * if (maxSum < 0)
         * return 0;
         */
        return maxSum;
    }
}
