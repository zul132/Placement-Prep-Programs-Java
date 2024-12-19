/* 
    OPTIMAL SOLUTION
    Intuition: We will linearly travel the array. We can maintain a minimum from the start of the array 
    and compare it with every element of the array, if it is greater than the minimum then take the difference 
    and maintain it in max, otherwise update the minimum.
*/
// Time complexity: O(n)
// Space Complexity: O(1)

public class Optimal_Stock_Buy_Sell {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;

        // for loop to traverse the array linearly
        for (int i = 0; i < n; i++) {
            // Update the minPrice if it is greater than the current element of the array
            if (prices[i] < minPrice)
                minPrice = prices[i];
            // Take the difference of the minPrice with the current element of the array and
            // compare and maintain it in maxPro.
            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }

        return maxPro;
    }
}
