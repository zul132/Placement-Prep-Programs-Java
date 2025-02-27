package Third_Largest_Element;
/* 
    Given an array, arr of positive integers. Find the third largest element in it. 
    Return -1 if the third largest element is not found.

    Naive Approach (by sorting):
    The idea is to sort the array in Ascending order and return the third largest element 
    in the array which will be present at (n-3)’th index.
    (OR)
    Sort the array in Descending order and return the 2nd index element which will be the third largest element.

    Test Cases: 1110 / 1120 passed on GeekForGeeks

    Examples:
    Input: arr[] = [2, 4, 1, 3, 5]
    Output: 3
    Explanation: The third largest element in the array [2, 4, 1, 3, 5] is 3.

    Input: arr[] = [10, 2]
    Output: -1
    Explanation: There are less than three elements in the array, so the third largest element cannot be determined.
*/

// Time Complexity: O(n * log n) --> depends on the sorting algo used
// Space Complexity: O(1)

public class Naive_Approach_By_Sorting {
    int thirdLargest(int arr[]) {
        int n = arr.length;

        /*
         * If there are less than 3 elements in the array, then the third largest
         * element cannot be determined.
         */
        if (n < 3) {
            return -1;
        } else {
            // Sort the array in descending order and return the 3rd index element
            for (int i = 1; i < n; i++) {
                int key = arr[i];
                int j = i - 1;

                while ((j >= 0) && (arr[j] < key)) {
                    arr[j + 1] = arr[j];
                    j--;
                }

                arr[j + 1] = key;
            }

            /*
             * Return the Third largest element which is the third element (2nd index) of
             * the sorted array
             */
            return arr[2];
        }
    }
}
