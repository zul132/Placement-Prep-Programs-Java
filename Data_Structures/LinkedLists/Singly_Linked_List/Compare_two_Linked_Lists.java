/* 
    You’re given the pointer to the head nodes of two linked lists. Compare the data in the nodes of the linked lists to check 
    if they are equal. If all data attributes are equal and the lists are the same length, return 1. Otherwise, return 0.

    EXAMPLE:
    llist1 = 1->2->3->NULL
    llist2 = 1->2->3->4->NULL
    The two lists have equal data attributes for the first 3 nodes. llist2 is longer tho, so the lists are not equal. Return 0.

    Sample Input
    2
    2
    1
    2
    1
    1
    2
    1
    2
    2
    1
    2
    Sample Output
    0
    1
*/

public class Compare_two_Linked_Lists {
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode t1 = head1;
        SinglyLinkedListNode t2 = head2;
        int len1 = 0, len2 = 0;
        while (t1 != null && t2 != null) {
            if (t1.data != t2.data)
                return false;
            else {
                t1 = t1.next;
                t2 = t2.next;
                len1++;
                len2++;
            }
        }

        while (t1 != null) {
            t1 = t1.next;
            len1++;
        }
        while (t2 != null) {
            t2 = t2.next;
            len2++;
        }
        if (len1 != len2)
            return false;

        return true;
    }

    public static void main(String[] args) {

    }
}
