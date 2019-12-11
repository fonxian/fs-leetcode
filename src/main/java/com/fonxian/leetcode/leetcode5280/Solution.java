package com.fonxian.leetcode.leetcode5280;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Fang
 * @since 2019-12-08
 */
public class Solution {


    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int key = groupSizes[i];
            if (!map.containsKey(key)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            } else {
                List<Integer> list = map.get(key);
                list.add(i);
            }
        }
        for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
            List<Integer> list = m.getValue();
            int key = m.getKey();
            int n = 0;
            while (n < list.size()) {
                List<Integer> newList = list.subList(n, n+key);
                res.add(newList);
                n += key;
            }

        }
//        System.out.println(JSONObject.toJSONString(res));
//        System.out.println(JSONObject.toJSONString(map));
        return res;
    }

    public static void main(String[] args) {
//        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        int[] groupSizes = {2,1,3,3,3,2};
        Solution solution = new Solution();
        System.out.println(solution.groupThePeople(groupSizes));
    }

}
