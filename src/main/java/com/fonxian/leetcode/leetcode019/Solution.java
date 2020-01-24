package com.fonxian.leetcode.leetcode019;


/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 *
 * Status:AC
 *
 * @author Michael Fang
 * @since 2020-01-24
 */
public class Solution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 获取链表的长度
        int size = getSize(head);
        int location = size - n + 1;
        ListNode tmp = dummy.next;
        // 删除正数位置的节点
        ListNode prev = dummy;
        int current = 1;
        while (tmp != null) {
            if (current == location) {
                if (tmp.next != null) {
                    prev.next = tmp.next;
                }else{
                    prev.next = null;
                }
                break;
            }
            prev = tmp;
            tmp = tmp.next;
            current++;
        }
        return dummy.next;
    }

    private static int getSize(ListNode head) {
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    private static void bianli(ListNode head) {
        System.out.println("输出结果：");
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    private static void test1() {

        ListNode head = new ListNode(1);

        System.out.println(getSize(head));
        head = removeNthFromEnd(head, 1);
        bianli(head);
    }

    private static void test2() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(getSize(head));
        head = removeNthFromEnd(head, 2);
        bianli(head);
    }

    private static void test3() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;

        System.out.println(getSize(node1));
        node1 = removeNthFromEnd(node1, 2);
        bianli(node1);
    }

    public static void main(String[] args) {
        test1();
        System.out.println("--------");
        test2();
        System.out.println("--------");
        test3();
    }

}
