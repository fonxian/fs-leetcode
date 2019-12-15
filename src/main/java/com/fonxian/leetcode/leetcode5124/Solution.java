package com.fonxian.leetcode.leetcode5124;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/weekly-contest-167/problems/sequential-digits/
 *
 * @author Michael Fang
 * @since 2019-12-15
 */
public class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        //判断有多少位
        int lowWei = getWei(low);
        int highWei = getWei(high);
        List<Integer> res = new ArrayList<>();
        for (int i = lowWei; i <= highWei; i++) {
            List<Integer> list = getSequentialDigits(i, low, high);
            if (!list.isEmpty()) {
                res.addAll(list);
            }
        }
        return res;
    }

    private int getWei(int val) {
        int n = 0;
        while (val % 10 != 0 || val / 10 != 0) {
            n++;
            val /= 10;
        }
        return n;
    }

    private List<Integer> getSequentialDigits(int wei, int low, int high) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int tmp = i;
            int tempWei = wei;
            int res = 0;
            boolean ban = false;
            while (tempWei > 0) {
                res += tmp * Math.pow(10, tempWei - 1);
                tempWei--;
                if (tmp > 9) {
                    ban = true;
                    break;
                }
                tmp++;
            }

            if (res > high) {
                break;
            } else {
                if (!ban && res >= low) {
                    list.add(res);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//            System.out.println(solution.getWei(99991));
        System.out.println(JSON.toJSONString(solution.sequentialDigits(1000, 13000)));
//        System.out.println(JSON.toJSONString(solution.getSequentialDigits(3, 100, 300)));
    }

}
