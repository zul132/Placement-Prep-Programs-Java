/* 
    Reverse a given Linked List using recursion. 
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

public class Recursive_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Reverse the rest of the list
        ListNode revHead = reverseList(head.next);

        // Make the current head the last node
        head.next.next = head;

        head.next = null;

        // Return the new head of the reversed list
        return revHead;
    }
}
