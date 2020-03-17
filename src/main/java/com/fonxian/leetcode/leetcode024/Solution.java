package com.fonxian.leetcode.leetcode024;


import com.fonxian.leetcode.base.LinkedListTool;
import com.fonxian.leetcode.base.ListNode;

/**
 * @author Michael Fang
 * @since 2020-03-18
 */

public class Solution {

    public static ListNode swapPairs(ListNode head) {
        ListNode thread = new ListNode(-1);
        // s a b
        // s -> b
        // a -> b.next
        // b -> a
        // c -> c.next.next
        if(head == null || head.next == null){
            return head;
        }
        thread.next = head;
        ListNode c = thread;
        while(c.next != null && c.next.next != null){
            ListNode a = c.next;
            ListNode b = c.next.next;
            c.next = b;
            a.next = b.next;
            b.next = a;
            c = c.next.next;
        }
        return thread.next;
    }

    public static void main(String[] args) {
        ListNode root = LinkedListTool.getSample();
        root = swapPairs(root);
        LinkedListTool.print(root);
    }

}
