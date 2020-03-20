package com.fonxian.interview.interview06;

import com.fonxian.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题06. 从尾到头打印链表
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-20
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int len = list.size();
        int[] rst = new int[len];
        for(int i = len-1;i>=0;i--){
            rst[len - 1 - i] = list.get(i);
        }
        return rst;
    }

}
