/*
    Given an array arr. Your task is to find the minimum and maximum elements in the array.

    Note: Return a Pair that contains two elements the first one will be a minimum element and the second will be a maximum.

    Example:
    Input: arr[] = [3, 2, 1, 56, 10000, 167]
    Output: 1 10000
    Explanation: minimum and maximum elements of array are 1 and 10000.
*/
// Time Complexity: O(n)
// Auxiliary Space: O(1)

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class MinMaxInArray {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int n = arr.length;
        Integer min = arr[0];
        Integer max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        return new Pair(min, max);
    }
}
