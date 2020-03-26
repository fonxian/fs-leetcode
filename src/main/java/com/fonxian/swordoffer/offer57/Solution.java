package com.fonxian.swordoffer.offer57;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-27
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:nums){
            map.put(num,target-num);
        }
        for(int num:nums){
            if(map.get(map.get(num)) != null){
                int[] rst = {num,map.get(num)};
                return rst;
            }
        }
        return null;
    }

}
