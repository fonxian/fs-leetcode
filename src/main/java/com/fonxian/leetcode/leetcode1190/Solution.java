package com.fonxian.leetcode.leetcode1190;

/**
 * https://leetcode-cn.com/contest/weekly-contest-154/problems/k-concatenation-maximum-sum/
 * <p>
 * (ed(et(oc))el)
 * <p>
 * <p>
 * (ed(et(oc))el)
 * 0 = ( len-1 = )
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2019-09-15
 */
public class Solution {

    public String reverseParentheses(String s) {
        int len = s.length();
        int left = -1;
        int right = len + 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                left = Math.max(i, left);
            }

        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')' && i>left) {
                right = Math.min(i, right);
            }
        }

        if (left == -1 && right == len + 1) {
            return s;
        }
        String tmp = new StringBuilder(s.substring(left + 1, right)).reverse().toString();
        tmp = s.substring(0,left) + tmp + s.substring(right+1,len);
        return reverseParentheses(tmp);
    }

    public static void main(String[] args) {

//        String str = "(u(love)i)";
        String str = "(ed(et(oc))el)";
//        String str = "(abcd)";
        str = "ta()usw((((a))))";
//
        //le(et(oc))de
        //le(etco)de
//        String[] arr = str.split("\\(");
//        System.out.println(Arrays.toString(arr));
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses(str));
    }

}
