package com.fonxian.leetcode.leetcode5197;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * https://leetcode-cn.com/contest/weekly-contest-155/problems/minimum-absolute-difference/
 * <p>
 * status:AC
 *
 * @author Michael Fang
 * @since 2019-09-22
 */
public class Solution {

    class Test {
        public List<Integer> list;
        public Integer num;
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int len = arr.length;
        List<Test> testlist = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        //数组排好序
        Arrays.sort(arr);
        int last = arr[0];
        int minRes = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {

            List<Integer> list = new ArrayList<>();
            list.add(last);
            list.add(arr[i]);

            Test test = new Test();
            test.list = list;
            test.num = arr[i] - last;
            //获取最小差值
            minRes = test.num < minRes ? test.num : minRes;
            testlist.add(test);
            last = arr[i];
        }
        //取出等于最小差值的数组
        for (Test test : testlist) {
            if (test.num == minRes) {
                res.add(test.list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
//        int[] arr = {4,2,1,3};
        int[] arr = {1, 3, 6, 10, 15};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.minimumAbsDifference(arr);
        System.out.println(JSONObject.toJSONString(res));
    }

}
