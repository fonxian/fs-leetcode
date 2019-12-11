package com.fonxian.leetcode.leetcode1276;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 *
 * @author Michael Fang
 * @since 2019-12-01
 */
public class Solution {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int x = (tomatoSlices - 2 * cheeseSlices) / 2;
        int y = cheeseSlices - x;

        list.add(new Double(x).intValue());
        list.add(new Double(y).intValue());
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int tomatoSlices = 16, cheeseSlices = 7;
//        int tomatoSlices = 2, cheeseSlices = 1;
//        int tomatoSlices = 2537427, cheeseSlices = 1;
        int tomatoSlices = 2537427, cheeseSlices = 860448;
//        int tomatoSlices = 0, cheeseSlices = 0;
//        int tomatoSlices = 17, cheeseSlices = 4;
        System.out.println(solution.numOfBurgers(tomatoSlices, cheeseSlices));
    }

}
