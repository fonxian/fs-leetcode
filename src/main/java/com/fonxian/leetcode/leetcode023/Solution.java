package com.fonxian.leetcode.leetcode023;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * 23. 合并K个排序链表
 * <p>
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-18
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        ListNode head = lists[0];
        for (int i = 1; i < len; i++) {
            head = mergeList(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1.next = mergeList(l1.next, l2);
        } else {
            head = l2;
            l2.next = mergeList(l1, l2.next);
        }
        return head;
    }

}
