/*
    Leetcode Daily Question 
    1007. Minimum Domino Rotations For Equal Row

    In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. 
    (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
    
    We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
    
    Return the minimum number of rotations so that all the values in tops are the same, 
    or all the values in bottoms are the same.

    If it cannot be done, return -1.

    Example 1:
    Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
    Output: 2
    Explanation: 
    If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2.

    Example 2:
    Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
    Output: -1
    Explanation: 
    In this case, it is not possible to rotate the dominoes to make one row of values equal.
*/
/*  GREEDY APPROACH + SINGLE PASS PRUNING:
    Time Complexity: O(n)
    Space complexity : O(1) 

*/

public class Minimum_Domino_Rotations {
    /*
     * INTUITION:
     * The key idea is that if it's possible to make all values in a row equal, then
     * the common value must appear in every domino.
     * Therefore, we can check the first domino's top and bottom values as potential
     * candidates for the common value.
     * 
     * Our two target values are tops[0] and bottoms[0] --> If either of these
     * values are found in every domino,
     * then it is possible to make all the dominos show either tops[0] or bottoms[0]
     * across one entire row (top || bottom).
     * 
     * We can then count the number of rotations needed to make the entire top and
     * bottom rows as the target
     * and return the minimum rotations count.
     * If neither value can be made to appear in every domino, we return -1.
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Step 1: Try to make all values equal to tops[0] across a row
        int result = check(tops[0], tops, bottoms);

        // Step 2: If tops[0] failed, try bottoms[0]
        if (result != -1)
            return result;

        // Step 3: Return result from checking bottoms[0]
        return check(bottoms[0], tops, bottoms);
    }

    // Step 4: Helper function to count rotations to make all values = target
    public int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0; // Rotations needed to bring target to top
        int rotateBottom = 0; // Rotations needed to bring target to bottom

        for (int i = 0; i < tops.length; i++) {
            // If target is not on either side, it's impossible
            if (tops[i] != target && bottoms[i] != target)
                return -1;

            // If top doesn't have the target, it must be rotated 
            if (tops[i] != target)
                rotateTop++;

            // If bottom doesn't have the target, it must be rotated 
            if (bottoms[i] != target)
                rotateBottom++;
        }

        // Return the minimum of the two rotation counts
        return Math.min(rotateTop, rotateBottom);
    }

}
