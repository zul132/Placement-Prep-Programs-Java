/*
    Q3. LeetCode 3690. Split and Merge Array Transformation
    You are given two integer arrays nums1 and nums2, each of length n. You may perform the following 
    split-and-merge operation on nums1 any number of times:

    1. Choose a subarray nums1[L..R].
    2. Remove that subarray, leaving the prefix nums1[0..L-1] (empty if L = 0) and the suffix nums1[R+1..n-1] (empty if R = n - 1).
    3. Re-insert the removed subarray (in its original order) at any position in the remaining array (i.e., between any two elements, at the very start, or at the very end).

    Return the minimum number of split-and-merge operations needed to transform nums1 into nums2.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Split_and_Merge_Array_Transformation {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;

        /* Convert both arrays to Lists for easier comparison. */
        List<Integer> n1 = new ArrayList<>();
        for (int num : nums1) {
            n1.add(num);
        }
        List<Integer> n2 = new ArrayList<>();
        for (int num : nums2) {
            n2.add(num);
        }

        if (n1.equals(n2)) {
            return 0;
        }

        /* Enqueue each array state alongside its current operation count (steps) */
        Queue<List<Integer>> queue = new LinkedList<>();
        /* Maintain a visited HashSet to avoid revisiting states. */
        Set<List<Integer>> visited = new HashSet<>();

        /* Start the BFS with the whole 'nums1' array itself */
        queue.offer(n1);
        visited.add(n1);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // Remove the head (first element) --> Dequeued state
                List<Integer> curr = queue.poll();
                if (curr.equals(n2)) {
                    // Stop if dequeued state is nums2, and return its associated operation count.
                    return steps;
                }

                /*
                 * For each dequeued state, generate all possible "split-and-merge" successors
                 * by choosing every valid subarray [L..R], removing it, and inserting it at
                 * every possible position.
                 */
                for (int l = 0; l < n; l++) {
                    for (int r = l; r < n; r++) {
                        // Remove the [L..R] subarray by Splitting & Merging
                        List<Integer> left = new ArrayList<>(curr.subList(0, l));
                        List<Integer> right = new ArrayList<>(curr.subList(r + 1, n));
                        List<Integer> remove = new ArrayList<>(curr.subList(l, r + 1));

                        List<Integer> newList = new ArrayList<>();
                        newList.addAll(left);
                        newList.addAll(right);

                        /*
                         * If after removing the [L..R] subarray, remaining array size is N, then there
                         * are N + 1 possible positions for inserting [L..R]
                         */
                        for (int idx = 0; idx < newList.size() + 1; idx++) {
                            List<Integer> finalList = new ArrayList<>(newList);
                            // Insert the removed elements [L..R] at idx position
                            finalList.addAll(idx, remove);
                            if (!visited.contains(finalList)) {
                                visited.add(finalList);
                                queue.offer(finalList);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        // If BFS completes without finding nums2, return -1
        return -1;
    }
}
