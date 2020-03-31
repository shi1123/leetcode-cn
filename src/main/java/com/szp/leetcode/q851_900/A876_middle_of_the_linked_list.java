package com.szp.leetcode.q851_900;

public class A876_middle_of_the_linked_list {
    /**
     *
    Definition for singly-
     linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null)
                return head;
            if (head.next.next == null)
                return head.next;
            ListNode next = head.next.next;
            while (next != null) {
                if (next.next == null) {
                    return head.next;
                } else {
                    next = next.next;
                    if (next.next == null) {
                        return head.next.next;
                    } else {
                        head = head.next;
                        next = next.next;
                    }
                }
            }
            return head;
        }
    }
}
