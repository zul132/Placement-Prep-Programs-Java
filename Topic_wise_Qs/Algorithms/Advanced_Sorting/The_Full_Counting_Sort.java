package Advanced_Sorting;
/* 
    The Full Counting Sort:
    Implement a stable Counting Sort to order a list of strings associated with integers. 
    If two strings are associated with the same integer, they must be printed in their original order, 
    i.e. your sorting algorithm should be stable. There is one other twist: strings in the first half 
    of the array are to be replaced with the character - (dash, ascii 45 decimal).

    Note: Insertion Sort and the simple version of Quicksort are stable, but the faster in-place version 
    of Quicksort is not since it scrambles around elements while sorting.

    Sample Input:
    20
    0 ab
    6 cd
    0 ef
    6 gh
    4 ij
    0 ab
    6 cd
    0 ef
    6 gh
    0 ij
    4 that
    3 be
    0 to
    1 be
    5 question
    1 or
    2 not
    4 is
    2 to
    4 the

    Sample Output:
    - - - - - to be or not to be - that is the question - - - -

    Explanation:
    The correct order is shown below. In the array at the bottom, strings from the first half of the original array were replaced with dashes.
    0 ab
    0 ef
    0 ab
    0 ef
    0 ij
    0 to
    1 be
    1 or
    2 not
    2 to
    3 be
    4 ij
    4 that
    4 is
    4 the
    5 question
    6 cd
    6 gh
    6 cd
    6 gh

    sorted = [['-', '-', '-', '-', '-', 'to'], ['be', 'or'], ['not', 'to'], ['be'], 
    ['-', 'that', 'is', 'the'], ['question'], ['-', '-', '-', '-'], [], [], [], []]

*/

/* 
    Key Concepts
    Counting Sort: Counting Sort is a linear-time, non-comparison-based sorting algorithm. It’s especially efficient 
    when the range of integer values is known and limited.
    
    Stability in Sorting: A stable sort ensures that elements with the same key retain their relative order from the original input. 
    In this challenge, stability is crucial to keep the original order for strings associated with identical integers.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        int n = arr.size();

        /*
         * Identify the highest integer value, maxIndex in the input to determine how
         * many buckets we need
         */
        int maxIndex = 0;
        for (List<String> element : arr) {
            // maxIndex = Math.max(maxIndex, Integer.parseInt(element.get(0)));
            int index = Integer.parseInt(element.get(0));
            if (index > maxIndex)
                maxIndex = index;
        }

        /*
         * Create a list of buckets to store strings associated with each integer value
         */
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxIndex; i++) {
            buckets.add(new ArrayList<>()); // Initialize each bucket
        }

        /*
         * Fill the buckets while replacing the strings in the first half of the array
         * with "-"
         */
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(arr.get(i).get(0));
            // check if the string lies in the first half, if yes then replace it with "-"
            String value = (i < n / 2) ? "-" : arr.get(i).get(1);
            buckets.get(index).add(value);
        }

        // Collect the strings from all the buckets in order and print the result
        StringBuilder result = new StringBuilder();
        for (List<String> bucket : buckets) {
            for (String str : bucket) {
                result.append(str).append(" ");
            }
        }

        // Print the final result
        System.out.println(result.toString().trim());

    }

}

public class The_Full_Counting_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
