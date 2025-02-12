/* 
    206. Reverse Linked List
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example:
    Input: head = 1 -> 2 -> 3 -> 4 -> 5
    Output: 5 -> 4 -> 3 -> 2 -> 1

*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        // Initialize three pointers - prev, next and curr
        ListNode prev = null, next = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev; /*
                               * update current element's next as its prev to reverse the pointer of the node
                               */
            // move to the next node
            prev = curr;
            curr = next;
        }

        /*
         * Once all the nodes are reversed, the prev pointer will the new head of the
         * reversed list.
         */
        return prev;
    }

}
