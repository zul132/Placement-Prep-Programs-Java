/* 
    Problem: Count Covered Buildings
    You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, 
    where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].

    A building is covered if there is at least one building in all four directions: left, right, above, and below.
    Return the number of covered buildings.

    Complexity Analysis:
    Time Complexity: O(N), where N is the number of buildings.
    One pass to build the min/max maps.
    One pass to check each building. 

    Space complexity: O(N) to store the min/max for each unique x and y.
*/

public class Optimal_Count_Covered_Buildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // Use hashmaps to precompute the minimum and maximum coordinates for each row
        // and column
        Map<Integer, int[]> yRangeGivenX = new HashMap<>();
        Map<Integer, int[]> xRangeGivenY = new HashMap<>();

        // First pass to build the min/max maps
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            yRangeGivenX.putIfAbsent(x, new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
            yRangeGivenX.get(x)[0] = Math.min(yRangeGivenX.get(x)[0], y);
            yRangeGivenX.get(x)[1] = Math.max(yRangeGivenX.get(x)[1], y);

            xRangeGivenY.putIfAbsent(y, new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
            xRangeGivenY.get(y)[0] = Math.min(xRangeGivenY.get(y)[0], x);
            xRangeGivenY.get(y)[1] = Math.max(xRangeGivenY.get(y)[1], x);
        }

        int count = 0;
        // Next pass to check each building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            if (x > xRangeGivenY.get(y)[0] && x < xRangeGivenY.get(y)[1] && y > yRangeGivenX.get(x)[0]
                    && y < yRangeGivenX.get(x)[1])
                count++;
        }

        return count;
    }
}
