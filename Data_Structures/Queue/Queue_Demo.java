/*
    To first implement Queue using a Linked List. Then process q queries, where each query is one of the following 3 types:

    1 x: Enqueue element x into the end of the queue.
    2: Dequeue the element at the front of the queue.
    3: Print the element at the front of the queue.
 */

import java.util.Scanner;

public class Queue_Demo {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    // enqueue() to insert element at the end of the queue
    void enqueue(int data) {
        Node n = new Node(data);
        if (front == null) {
            // if node is empty make n as both the front and rear
            front = rear = n;
        } else {
            // insert node n at the end
            rear.next = n;
            rear = n;
        }
    }

    // dequeue() to delete element from the front of the queue
    void dequeue() {
        if (front == null) {
            System.out.println("Empty Queue");
        } else {
            front = front.next;
            // if queue becomes empty after deletion, make rear as null
            if (front == null)
                rear = null;
        }
    }

    // peek() to print the front element of the queue
    void peek() {
        if (front == null) {
            System.out.println("Empty Queue");
        } else {
            System.out.println(front.data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue_Demo queue = new Queue_Demo();
        int q = sc.nextInt(); // Input the no of queries

        for (int i = 0; i < q; i++) {
            // input the query option
            int op = sc.nextInt();

            if (op == 1) {
                int x = sc.nextInt();
                queue.enqueue(x);
            } else if (op == 2) {
                queue.dequeue();
            } else if (op == 3) {
                queue.peek();
            } else {
                System.out.println("Invalid Operation");
            }
        }

        sc.close();
    }

}
