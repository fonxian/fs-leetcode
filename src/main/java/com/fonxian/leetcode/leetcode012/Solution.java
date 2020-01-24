package com.fonxian.leetcode.leetcode012;

/**
 * @author Michael Fang
 * @since 2019-12-14
 */
public class Solution {

    private static Roman[] roman = new Roman[7];

    static {
        roman[0] = new Roman("I", 1);
        roman[1] = new Roman("V", 5);
        roman[2] = new Roman("X", 10);
        roman[3] = new Roman("L", 50);
        roman[4] = new Roman("C", 100);
        roman[5] = new Roman("D", 500);
        roman[6] = new Roman("M", 1000);
    }

    public String intToRoman(int num) {
        // 第一种 MM 2000
        // 第二种 MD
        // 第三种 CDI
        String res = "";
        for (int i = roman.length - 1; i >= 0; i--) {
            if (num > roman[i].v) {
                int big = num / roman[i].v;
                num = num - roman[i].v * big;
                for (int j = 1; j <= big; j++) {
                    res += roman[i].s;
                }
            }
            for (int k = i - 1; k >= 0; k--) {
                if (num == roman[i].v - roman[k].v) {
                    num = 0;
                    res += roman[k].s + roman[i].s;
                    break;
                }
            }
        }
        // 处理400这种情况


        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1900));
    }

    static class Roman {
        public String s;
        public int v;

        public Roman(String s, int v) {
            this.s = s;
            this.v = v;
        }
    }

}
