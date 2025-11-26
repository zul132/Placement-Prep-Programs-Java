/*
    LeetCode 3217. Delete Nodes From Linked List Present in Array
    link: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/ 

    You are given an array of integers nums and the head of a linked list. Return the head of 
    the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
*/

import java.util.HashSet;

public class Delete_Nodes_From_Linked_List_Present_in_Array {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Hash the array of integers for easy operation
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            map.add(num);
        }

        // Case 1: head contains a value which is present in nums
        while (head != null && map.contains(head.val)) {
            head = head.next;
        }

        // General Case: If the next node's value is present in nums then remove that
        // node by updating the current node's next.
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            while (curr.next != null && map.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }

            curr = curr.next;
        }

        // return the head of the modified Linked List
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
