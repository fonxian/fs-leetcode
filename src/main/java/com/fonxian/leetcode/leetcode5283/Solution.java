package com.fonxian.leetcode.leetcode5283;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/contest/weekly-contest-167/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @author Michael Fang
 * @since 2019-12-15
 */
public class Solution {

    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        List<Integer> intList = new ArrayList<>();
        while (temp != null) {
            intList.add(temp.val);
            temp = temp.next;
        }
        int size = intList.size();
        int res = 0;
        for (int i : intList) {
            res += i * Math.pow(2, --size);
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);

        head.next = node1;
        node1.next = node2;

        Solution solution = new Solution();

        System.out.println(solution.getDecimalValue(head));
    }

}
