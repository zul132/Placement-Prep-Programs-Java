/* 
    Given the pointer to the head node of a linked list and an integer to insert at a certain position, create a new node with 
    the given integer as its data attribute, insert this node at the desired position and return the head node.
    A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. 
    The head pointer given may be null meaning that the initial list is empty.

    EXAMPLE
    head  refers to the first node in the list 1-->2-->3
    data = 4 
    position = 2
    Insert a node at position 2 with data = 4. The new list is 1-->2-->4-->3

    Sample Input:
    5
    11
    9
    19
    10
    4
    20
    3
    Sample Output:
    11 9 19 20 10 4
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

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
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
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode nn = new SinglyLinkedListNode(data);
        // if the List is empty return pointer to the new node
        if (llist == null) {
            return nn;
        }
        SinglyLinkedListNode temp = llist;
        int count = 0;
        // navigate to the node immediatly before the specified position
        while (count < position - 1) {
            temp = temp.next;
            count += 1;
        }
        // insert the new node
        nn.next = temp.next;
        temp.next = nn;

        // return the head of the revsied list
        return llist;

    }

}

public class Insert_Node_At_Position {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

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

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode llist_head = Result.insertNodeAtPosition(llist.head, data, position);

        SinglyLinkedListPrintHelper.printList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
