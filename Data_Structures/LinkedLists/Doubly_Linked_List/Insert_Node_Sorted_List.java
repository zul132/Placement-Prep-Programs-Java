/*
    Given a reference to the head of a doubly-linked list and an integer, 'data', create a new DoublyLinkedListNode object having 
    data value 'data' and insert it at the proper location to maintain the sort.

    Example:
    'head' refers to the list: 1 <-> 2 <-> 4 --> NULL
    data = 3
    Return a reference to the new list: 1 <-> 2 <-> 3 <-> 4 --> NULL

    Sample Input:
    STDIN   Function
    -----   --------
    1       t = 1
    4       n = 4
    1       node data values = 1, 3, 4, 10
    3
    4
    10
    5       data = 5

    Sample Output
    1 3 4 5 10
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

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
            throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {
    /* THIS IS THE ACTUAL SOLUTION PART */
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode n = new DoublyLinkedListNode(data);
        // if the sorted List is null, return the new node N.
        if (llist == null) {
            return n;
        }

        // In case new node's sorted position is at the beginning of the List
        if (data < llist.data) {
            n.next = llist;
            llist.prev = n;
            return n;
        }

        /*
           In case List has only one element and the given data is larger, then it has
           to be inserted after the first element.
         */
        if ((llist.next == null) && (data > llist.data)) {
            llist.next = n;
            n.prev = llist;
            return llist;
        }

        DoublyLinkedListNode temp = llist.next;
        while ((data >= temp.data) && temp.next != null) {
            temp = temp.next;
        }
        /* sorted position of node N is somewhere in the middle of the List */
        if (data < temp.data) {
            n.next = temp;
            temp.prev.next = n;
            n.prev = temp.prev;
            temp.prev = n;
        } // Node n is to be inserted at the end of the List
        else {
            temp.next = n;
            n.prev = temp;
        }

        return llist;
    }

}

public class Insert_Node_Sorted_List {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList llist = new DoublyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int data = Integer.parseInt(bufferedReader.readLine().trim());

                DoublyLinkedListNode llist1 = Result.sortedInsert(llist.head, data);

                DoublyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
