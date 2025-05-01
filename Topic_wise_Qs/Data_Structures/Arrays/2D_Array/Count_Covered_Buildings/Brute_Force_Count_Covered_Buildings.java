/* 
    Leetcode Weekly Contest 447: 3531. Count Covered Buildings
    
    You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, 
    where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].

    A building is covered if there is at least one building in all four directions: left, right, above, and below.
    Return the number of covered buildings.

    Example 1:
    Input: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
    Output: 1

    Explanation:
    Only building [2,2] is covered as it has at least one building:
        above ([1,2])
        below ([3,2])
        left ([2,1])
        right ([2,3])
    Thus, the count of covered buildings is 1.

    Example 3:
    Input: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]
    Output: 1

    Explanation:
    Only building [3,3] is covered as it has at least one building:
        above ([1,3])
        below ([5,3])
        left ([3,2])
        right ([3,5])
    Thus, the count of covered buildings is 1.
*/
/* 
    Brute Force Approach (PASSED 619 / 634 TEST CASES):
    1. Iterate through each building in the buildings array.
    2. For each building, check if it is covered from all four directions (above, below, left, right).
    3. If a building is covered from all four directions, increment the count.
    4. Return the final count of covered buildings.

    Complexity Analysis:
    Time Complexity: O(n^2), where n is the number of buildings.
    Space Complexity: O(1), as we are using only a constant amount of space.
    
    Note: The above approach is not optimal and will throw Time Limit Exceeded (TLE) error for large inputs. 
*/

public class Brute_Force_Count_Covered_Buildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int count = 0;

        for (int[] building : buildings) {
            // get the x,y coordinates of the building
            int x = building[0];
            int y = building[1];

            // check if the building is covered
            if (aboveCovered(x, y, buildings) && belowCovered(x, y, buildings) && leftCovered(x, y, buildings)
                    && rightCovered(x, y, buildings))
                count++;

        }
        return count;
    }

    // helper function to check if the building is covered from Above
    public boolean aboveCovered(int x, int y, int[][] buildings) {
        for (int[] building : buildings) {
            if ((building[0] < x) && (building[1] == y))
                // if a building is found above, return true
                return true;
        }

        return false;
    }

    // helper function to check if the building is covered from Below
    public boolean belowCovered(int x, int y, int[][] buildings) {
        for (int[] building : buildings) {
            if ((building[0] > x) && (building[1] == y))
                // if a building is found below, return true
                return true;
        }

        return false;
    }

    // helper function to check if the building is covered from the Left
    public boolean leftCovered(int x, int y, int[][] buildings) {
        for (int[] building : buildings) {
            if ((building[1] < y) && (building[0] == x))
                // if a building is found to the left, return true
                return true;
        }

        return false;
    }

    // helper function to check if the building is covered from the Right
    public boolean rightCovered(int x, int y, int[][] buildings) {
        for (int[] building : buildings) {
            if ((building[1] > y) && (building[0] == x))
                // if a building is found to the left, return true
                return true;
        }

        return false;
    }
}
