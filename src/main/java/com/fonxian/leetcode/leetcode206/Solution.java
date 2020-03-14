package com.fonxian.leetcode.leetcode206;


/**
 * @author Michael Fang
 * @since 2020-03-14
 */
@SuppressWarnings("all")
public class Solution {

    public static ListNode reverseList1(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode currentNode = head;
        // 前一段节点
        ListNode prevNode = null;
        ListNode tmpNode = null;
        while (currentNode != null) {
            // 记录下当前节点的下一个节点
            tmpNode = currentNode.next;
            // 将当前的节点连接到之前的节点
            currentNode.next = prevNode;
            // 将当前节点和临时节点往后挪一位
            prevNode = currentNode;
            currentNode = tmpNode;
        }
        return prevNode;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        // 前一段节点
        ListNode prevNode = null;
        ListNode tmpNode = null;
        while (currentNode != null) {
            // 记录下当前节点的下一个节点
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                currentNode.next = prevNode;
                return currentNode;
            }
            ListNode nextNextNode = nextNode.next;
            // 将当前的节点连接到之前的节点
            currentNode.next = prevNode;
            // 将下一个节点指向当前节点
            nextNode.next = currentNode;
            // 将下下个节点保存为之后的当前节点
            currentNode = nextNextNode;
            // 将下一个节点保存为之前的节点
            prevNode = nextNode;
            if (currentNode == null) {
                return prevNode;
            }

        }
        return currentNode;
    }

    public static void bianli(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode root = reverseList3(head);

        bianli(root);

    }
}

