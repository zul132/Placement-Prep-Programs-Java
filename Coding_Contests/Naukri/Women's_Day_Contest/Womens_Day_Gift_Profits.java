/* 
    Problem Statement:
    A Women’s Empowerment Foundation is hosting a Women's Day Celebration where they want to distribute 
    special gifts to women attending the event. The foundation has n gift items available, where 
    the cost price of the i-th item is given by a[i] (0 ≤ i < n).

    To make the gifts affordable, they plan to sell some gifts at discounted rates, while keeping their earnings 
    as high as possible. They have set the following constraints:
        - They can only sell k items with a profit less than or equal to 20%.
        - The remaining (n - k) items they can sell with a profit less than or equal to 10%.
    
    The goal is to maximize the total earnings while adhering to these discount constraints.

    Input Format:
    The first line contains an integer n, the total number of gift items.
    The next n lines contain an integer a[i], representing the cost price of each gift item.
    The last line contains an integer k, the number of items that can be sold with a discount of up to 20%.
    
    Constraints:
    (1 <= n <= 10^5)
    (1 <= a[i] <= 10^9)
    (0 <= k <= n)

    Output Format:
    Print a single integer, representing the maximum earnings the foundation can achieve.
    
    Sample Input:
    5
    40
    20
    20
    10
    20
    2
    Sample Output:
    17

    Explanation:
    Initially, the earning is zero.
    First item  he will sell with 20% => earning = 8
    Second item  he will sell with 20% => earning = 8 + 4 = 12
    Third item  he will sell with 10% => earning = 12 + 2 = 14
    Fourth item  he will sell with 10% => earning = 14 + 1 = 15
    Fifth item  he will sell with 10% => earning = 15 + 2 = 17
*/

// 4 OUT OF 8 TESTCASES PASSED ONLY

import java.util.List;

public class Womens_Day_Gift_Profits {
    public static long solve(List<Integer> a, int k) {
        // Write your code here
        int n = a.size(); // no of gift items
        long earning = 0;

        // For first k items, sell with 20% profit
        for (int i = 0; i < k; i++) {
            int cost = a.get(i);
            long profit = cost / 5; // 20% of cost = cost / 5
            earning += profit;
        }

        for (int i = k; i < n; i++) {
            int cost = a.get(i);
            long profit = cost / 10;
            earning += profit;
        }

        return earning;
    }

}
