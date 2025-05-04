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
/* HASHING APPROACH 
   This solution uses a HashTable the frequency of each equivalent domino pair. 
   Here, we use the Cantor Pairing function to map the two numbers of the domino to a single unique number.

   Passed All 19 test cases on LeetCode.

   Time Complexity: O(n)
   Space Complexity: O(1)
   where n is the number of dominoes.
   The space complexity is O(1) because the size of the hash table is limited to the number of unique domino pairs.
*/

public class Hashing_Equivalent_Domino_Pairs {
    /*
     * We will use a hash map to count how many times each domino pair appears.
     * To create a unique identifier for each domino, we will use the Cantor Pairing
     * Function that will map two integers (x, y) to a single unique integer, which
     * we’ll use as a key in the hash map.
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<Long, Integer> freqTable = new HashMap<>();

        for (int[] dom : dominoes) {
            long pairValue = cantorPair(dom[0], dom[1]);
            /*
             * For each domino, add the current frequency of its Cantor value to the total
             * count (representing pairs with previous equivalent dominoes), then increment
             * the frequency.
             */
            count += freqTable.getOrDefault(pairValue, 0);
            freqTable.put(pairValue, freqTable.getOrDefault(pairValue, 0) + 1);
        }

        return count;
    }

    // Helper function to compute the Cantor Pair for the given domino integers
    public long cantorPair(int a, int b) {
        // Normalize the domino so that [a, b] and [b, a] map to the same (x, y)
        int x = Math.min(a, b), y = Math.max(a, b);
        long sum = x + y;
        return (sum * (sum + 1)) / 2 + y;
    }
}
