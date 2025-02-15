/*
    1352. Product of the Last K Numbers
    Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

    Implement the ProductOfNumbers class:
    - ProductOfNumbers() Initializes the object with an empty stream.
    - void add(int num) Appends the integer num to the stream.
    - int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that  
      always the current list has at least k numbers.

    The test cases are generated so that, at any time, the product of any contiguous sequence of numbers
     will fit into a single 32-bit integer without overflowing.

    Sample Input:
    ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
    [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

    Sample Output:
    [null,null,null,null,null,null,20,40,0,null,32]

    This is Approach 1 : Brute Force O(n)
*/
/*  Time Complexity: O(n)
    add(num): O(1) (simply appending to a list).
    getProduct(k): O(k) (iterating over k elements).
    Worst case: If k ≈ n, the time complexity becomes O(n) per query.
*/
/*  Space Complexity: 0(n)
    Since we store all the numbers in a list of size n.
*/

// Company Tags: Target, Apple, Meta, Google, Amazon, TikTok

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> nums;

    public ProductOfNumbers() {
        // Initialize a list to store the stream of integers
        nums = new ArrayList<>();
    }

    public void add(int num) {
        nums.add(num); // append num to the list
    }

    public int getProduct(int k) {
        int product = 1;
        int n = nums.size();

        // Iterate over the last k numbers and compute their product
        for (int i = n - k; i < n; i++) {
            product *= nums.get(i);
        }

        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
