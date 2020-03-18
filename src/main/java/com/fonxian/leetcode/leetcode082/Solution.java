package com.fonxian.leetcode.leetcode082;

import com.fonxian.leetcode.base.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *TODO
 * @author Michael Fang
 * @since 2020-03-18
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        // s a b
        //   1 1 2
        // r = head.val
        if(head == null){
            return head;
        }
        ListNode thread = new ListNode(-1);
        thread.next = head;
        ListNode c = thread;
        int r = Integer.MIN_VALUE;
        boolean repeat = false;
        while(c.next != null){
            ListNode a = c.next;
            if(a.val != r){
                r = a.val;
            }else{
                c = c.next;
            }
        }
        return thread.next;
    }
}
