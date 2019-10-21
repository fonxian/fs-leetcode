package com.fonxian.leetcode.leetcode5232;

import com.alibaba.fastjson.JSONObject;
import sun.font.CompositeGlyphMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fang
 * @since 2019-10-20
 */
public class Solution {

    public int balancedString(String s) {
        int len = s.length();
        int n = len / 4;
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("Q", 0);
        map.put("W", 0);
        map.put("E", 0);
        map.put("R", 0);

        for (int i = 0; i < len; i++) {
            String key = s.charAt(i) + "";
            int temp = map.get(key);
            map.put(key, ++temp);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() - n < 0) {
                res += entry.getValue() - n;
            }

        }
        System.out.println(JSONObject.toJSONString(map));
        return res * (-1);
    }

    public static void main(String[] args) {
        // 1 1 1 1
        String demo1 = "QWER";
        // 2 1 1 0
        String demo2 = "QQWE";
        // 3 1 0 0
        String demo3 = "QQQW";
        // 4 0 0 0
        String demo4 = "QQQQ";
        // 4 1 3 4
        String demo5 = "QQQQWEEERRRR";
        //
        String demo6 = "WWEQERQWQWWRWWERQWEQ";

        Solution solution = new Solution();

//        System.out.println(solution.balancedString(demo1));
//        System.out.println(solution.balancedString(demo2));
//        System.out.println(solution.balancedString(demo3));
//        System.out.println(solution.balancedString(demo4));
//        System.out.println(solution.balancedString(demo5));
        // -2 -1 3
        //QQQQQ RRR EEEE WWW WWWWW
        System.out.println(solution.balancedString(demo6));
    }

}
