/*
    You are given a pointer to the root of a binary search tree and values to be inserted into the tree. 
    Insert the values into their appropriate position in the binary search tree and return the root of the updated binary tree.

    Sample Input:
        4
       / \
      2   7
     / \
    1   3

    The value to be inserted is 6.

    Sample Output:
         4
       /   \
      2     7
     / \   /
    1   3 6
*/

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Insertion_BST {

    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            Node nn = new Node(data);
            return nn;
        }
        if (root.data > data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
