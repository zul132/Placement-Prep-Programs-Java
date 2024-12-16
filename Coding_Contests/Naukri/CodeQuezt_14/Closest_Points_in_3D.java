/* 
    Problem Statement
    You are given a list of points in a 3D space and a reference point (x0, y0, z0) Your task is to find the top k points 
    from the list that are closest to the reference point. The distance between two points (x1, y1, z1) and (x2, y2, z2) 
    is calculated using the Euclidean distance formula:

    distance = sqrt[(x2-x1)^2 + (y2-y1)^2 + (z2-z1)^2]

    Input Format:
        • The first line contains an integer X0, the x-coordinate of the reference point.
        • The second line contains an integer Y0, the y coordinate of the reference point.
        • The third line contains an integer z0, the z coordinate of the reference point.
        • The fourth line contains an integer N, the number of points.
        • The fifth line contains the integer 3 which denotes the number of columns in each row of the points.
        • The next N lines each contain three integers x, y, and z, representing the coordinates of each point in the 3D space.
        • The last line contains an integer k, the number of closest points to find.
    
    Output Format:
        • Print a 2D Integer Array, i.e. (k x 3) matrix containing the top k points from the list that are closest to the reference point.
*/

import java.util.ArrayList;
import java.util.List;

public class Closest_Points_in_3D {
    /*
     * Complete the 'closest' function below.
     * 
     * The function is expected to return an INTEGER 2D ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER X0
     * 2. INTEGER y0
     * 3. INTEGER z0
     * 4. INTEGER 2D ARRAY points
     * 5. INTEGER k
     */

    public static List<List<Integer>> closest(int x0, int y0, int z0, List<List<Integer>> points, int k) {
        // Write your code here
        List<List<Integer>> topKpoints = new ArrayList<List<Integer>>();

        return topKpoints;
    }
}
