package com.fonxian.leetcode.leetcode083;

import com.fonxian.leetcode.base.ListNode;

/**
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * status: AC
 *
 * @author Michael Fang
 * @since 2020-03-18
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return head;
        }
        ListNode c = head;
        int r = head.val;
        while(c!= null && c.next != null){
            ListNode a = c.next;
            if(a.val == r){
                c.next = a.next;
                a.next = null;
            }else{
                r = a.val;
                c = c.next;
            }

        }
        return head;
    }

}
