package com.fonxian.leetcode.leetcode5190;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-154/problems/k-concatenation-maximum-sum/
 *
 * (ed(et(oc))el)
 *
 * @author Michael Fang
 * @since 2019-09-15
 */
public class Solution {

    public String reverseParentheses(String s) {
        return "";
    }

    public static void main(String[] args) {

        String str = "(ed(et(oc))el)";
        //le(et(oc))de
        //le(etco)de
        String[] arr = str.split("\\(");
        System.out.println(Arrays.toString(arr));
    }

}
