package com.fonxian.interview.interview05;

/**
 * 面试题05. 替换空格
 *
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-21
 */
public class Solution {

    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

}
