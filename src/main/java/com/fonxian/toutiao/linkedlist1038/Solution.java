package com.fonxian.toutiao.linkedlist1038;

/**
 * @author Michael Fang
 * @since 2020-03-17
 */

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }

}
