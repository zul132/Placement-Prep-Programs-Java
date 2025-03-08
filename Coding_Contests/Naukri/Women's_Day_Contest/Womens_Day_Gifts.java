/* 
    Problem Statement:
    Aisha is planning a grand Women's Day celebration for her friends. She has N rupees to spend on gifts. 
    Each gift costs K rupees.
    Aisha, being a perfectionist, wants to ensure that she spends all of her money without any leftover change. 
    To achieve this, she is willing to add some extra amount to her budget.

    Your task is to help Aisha determine the minimum additional amount she needs to add to N so that 
    she can buy gifts without any money remaining.

    Input Format:
    The first line contains an integer N — the initial amount Aisha has.
    The second line contains an integer K — the cost of each gift.
    
    Constraints:
    1<=K,N<=10^6

    Output Format:
    Return an integer denoting the minimum additional amount Aisha needs to add to N so that she can purchase gifts 
    using all of her money.
    
    Sample Input:
    50
    4
    Sample Output:
    2

    Explanation:
    Aisha has 50 rupees, and each gift costs 4 rupees. If she adds 2 more rupees, she will have 52 rupees, 
    allowing her to buy 13 gifts without any leftover money.
*/

// ALL TESTCASES PASSED 
public class Womens_Day_Gifts {
    public static int buyGifts(int N, int K) {
        // Write your code here
        if (N % K == 0) {
            return 0;
        }

        // Sample input: N = 100, K = 6
        int minGifts = N / K; // 100/6 = 16

        int minCost = minGifts * K; // 16 * 6 = 96
        int rem = N - minCost; // 100 - 96 =
        return (K - rem); // 6 - 4 = 2
    }

}
