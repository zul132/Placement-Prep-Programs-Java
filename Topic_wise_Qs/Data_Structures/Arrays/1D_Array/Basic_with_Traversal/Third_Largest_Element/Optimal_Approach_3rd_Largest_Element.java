package Third_Largest_Element;
/* 
    Optimal Approach - Using Three Variables
    The idea is to traverse the array from start to end and to keep track of the three largest elements 
    up to that index (stored in variables). So after traversing the whole array, the variables would have stored 
    the indices (or value) of the three largest elements of the array.
*/

// Time Complexity: O(n)
// Space Complexity: O(1)

public class Optimal_Approach_3rd_Largest_Element {
    int thirdLargest(int arr[]) {
        int n = arr.length;

        /*
         * If there are less than 3 elements in the array, then the third largest
         * element cannot be determined.
         */
        if (n < 3) {
            return -1;
        } else {
            /*
             * Use three variables - first, second, & third to keep track of the first
             * largest, second largest and third largest element in the array respectively.
             */
            int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                if (arr[i] > first) {
                    third = second;
                    second = first;
                    first = arr[i];
                }

                else if (arr[i] > second) {
                    third = second;
                    second = arr[i];
                }

                else if (arr[i] > third) {
                    third = arr[i];
                }

            }

            // Return the thid largest element
            return third;
        }

    }
}
