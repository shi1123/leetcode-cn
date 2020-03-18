package com.szp.leetcode.q251_300;



/*
* 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

链接：https://leetcode-cn.com/problems/reverse-linked-list
* */
public class A206_Reverse_linked_list {
//     * Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(null == head || head.next == null)
                return head;
            return reverse(head);
        }

        private ListNode reverse(ListNode head) {
            if(head.next == null)
                return head;
            ListNode next = head.next;
            head.next = null;
            ListNode tail = reverse(next);
            next.next = head;
            return  tail;
        }
    }
}
