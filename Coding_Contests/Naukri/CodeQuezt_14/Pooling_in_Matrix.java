/* 
    Problem Statement
    Pooling is a key operation in many image processing and machine learning algorithms, 
    typically used to reduce the dimensionality of data.

    Given a 2D array matrix of size nxm and a pooling window of size kxk with a stride of 1, 
    return the max pool matrix. The max pool matrix is obtained by applying the max pooling 
    operation with the specified window and stride on the input matrix.

    Max pooling involves taking the maximum value within a kxk window of the array as you slide this window across the array.

    Input Format:
        • The first line contains an integer n - the number of rows in the matrix
        • The second line contains an integer m - the number of columns in the matrix.
        • The next n lines each contain m integers representing the matrix
        • The last line contains an integer k - the size of the pooling window

    Output Format:
        • Print the max pool matrix which is represented by n lines each containing m integers.
*/

import java.util.ArrayList;
import java.util.List;

public class Pooling_in_Matrix {
    /*
     * Complete the 'max_pooling' function below.
     * 
     * The function is expected to return an INTEGER 2D ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER 2D ARRAY matrix
     * 2. INTEGER K
     */

    public static List<List<Integer>> max_pooling(List<List<Integer>> matrix, int k) {
        // Write your code here
        List<List<Integer>> maxPool = new ArrayList<List<Integer>>();

        return maxPool;
    }

}
