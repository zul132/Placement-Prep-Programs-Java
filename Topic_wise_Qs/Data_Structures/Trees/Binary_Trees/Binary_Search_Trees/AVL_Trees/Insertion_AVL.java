/*
    Program to Insert and Display the given elements in an AVL Tree. Display the elements in ascending order.

    Sample Input 0:
    6
    40 20 34 56 78 12
    
    Sample Output 0:
    12 20 34 40 56 78
*/
import java.io.*;
import java.util.*;

class AVLNode {
    int key;
    int height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        left = null;
        height = 1;
        right = null;
    }
}

public class Insertion_AVL {
    // function to display the AVL tree elements in ascending order.
    static void inorder(AVLNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    static int height(AVLNode root) {
        if (root == null)
            return 0;
        return root.height;
    }

    /* Utility function to right rotate subtree rooted with node y */
    static AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // perform rotation
        x.right = y;
        y.left = T2;

        // update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // return new root
        return x;
    }

    /* Utility function to right rotate subtree rooted with node y */
    static AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // perform rotation
        y.left = x;
        x.right = T2;

        // update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // return new root
        return y;
    }

    static int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    static AVLNode insert(AVLNode root, int key) {
        // perform the normal BST insertion
        if (root == null)
            return new AVLNode(key);

        if (root.key > key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        // update height of this root node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // get the balance factor of root
        int balance = getBalance(root);

        /* If this node becomes unbalanced then there are 4 cases */

        // left left case
        if (balance > 1 && key < root.left.key) {
            return rightRotate(root);
        }
        // right right case
        if (balance < -1 && key > root.right.key) {
            return leftRotate(root);
        }
        // left right case
        if (balance > 1 && key > root.left.key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // right left case
        if (balance < -1 && key < root.right.key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // return the root pointer
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        AVLNode root = null;
        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        inorder(root);
    }
}