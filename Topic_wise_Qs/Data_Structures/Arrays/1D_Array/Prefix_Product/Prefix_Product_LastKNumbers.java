/* 
    Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

    Approach 2 : Prefix Product O(1)
    - While adding the numbers, keep all prefix products of numbers in an array, then calculate the
      product of last K elements in O(1) complexity using the formula - prefixProduct[size - 1] / prefixProduct[size - k -1]
    - When a zero number is added, clean the array of prefix products by resetting the array to 1.
      This is because any multiplication involving 0 results in 0, making previous prefix product values useless.

    Complexity Analysis:
        Time Complexity : O(1) 
        add(int num): O(1) (Appending to a list is constant time).
        getProduct(int k): O(1) (Retrieving values and dividing takes constant time).

        Space Complexity : O(n)
        O(n), where n is the number of elements added (prefix product array stores all products).

*/

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        /* The prefix product array starts with 1 to handle multiplication properly. */
        prefixProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            // If num is 0, then prefixProduct is reset to 1.
            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);
        } else {
            /*
             * Otherwise compute the prefix product as num * prefixProduct[size - 1] and add
             * it to the array
             */
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k >= size)
            // k >= 0 means there are not enough elements in prefixProduct array to
            // calculate product with so return 0
            return 0;

        return prefixProduct.get(size - 1) / prefixProduct.get(size - k - 1);

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
