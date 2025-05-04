/*
    Leetcode Daily Question
    1128. Number of Equivalent Domino Pairs

    Problem:
    Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] 
    if and only if either (a == c and b == d), or (a == d and b == c) - 
    that is, one domino can be rotated to be equal to another domino.

    Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

    Example 1:
    Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
    Output: 1

    Example 2:
    Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
    Output: 3
*/
/*
    BRUTEFORCE APPROACH 
    This solution uses a brute-force approach to iterate through all pairs of dominoes and check if they are equivalent.
    This is a simple but inefficient solution, especially for large inputs.

    Passed 18/19 test cases on LeetCode.

    Time Complexity: O(n^2)
    Space Complexity: O(1)
    where n is the number of dominoes.
*/

public class Bruteforce_Equivalent_Domino_Pairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;

        // Simple iterate through all combinations of domino pairs and increment the
        // count if the pairs are found to be equivalent.
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                // check if the domino pairs are equivalent
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
                        || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
                    count++;
                }
            }
        }

        return count;
    }

    // ALTERNATE CODE FOR BRUTEFORCE APPROACH
    public int alternateNumEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = dominoes[i][0];
                int b = dominoes[i][1];
                int c = dominoes[j][0];
                int d = dominoes[j][1];

                if (((a == c) && (b == d)) ||
                        ((a == d) && (b == c)))
                    count++;
            }
        }

        return count;
    }
}
