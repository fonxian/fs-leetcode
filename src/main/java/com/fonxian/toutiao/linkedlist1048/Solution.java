package com.fonxian.toutiao.linkedlist1048;

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

    /**
     * 解法1
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode index = null;

        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                index.next = p2;
                break;
            }
            if (p2 == null) {
                index.next = p1;
                break;
            }
            int pv1 = p1.val;
            int pv2 = p2.val;
            ListNode ss = pv1 < pv2 ? p1 : p2;
            ListNode tmp = ss.next;
            ss.next = null;
            if (head == null) {
                head = ss;
                index = head;
            } else {
                index.next = ss;
                index = index.next;
            }
            if (pv1 < pv2) {
                p1 = tmp;
            } else {
                p2 = tmp;
            }
        }
        return head;
    }

    /**
     * 解法2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists2(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists2(l1, l2.next);
        }
        return head;
    }

    public static void bianli(ListNode listNode) {
        ListNode tmp = listNode;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        ListNode rst = mergeTwoLists(node1, node4);
        bianli(rst);
    }

}
