package com.fonxian.leetcode.leetcode263;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 *
 * @author Michael Fang
 * @since 2020-03-27
 */
public class Solution {

    public boolean isUgly(int num) {

        while(num != 1){
            if(num == 0){
                return false;
            }
            if(num % 2 != 0 && num % 3 != 0 && num % 5 != 0){
                return false;
            }
            if(num % 5 == 0){
                num /= 5;
            }
            if(num % 3 == 0){
                num /= 3;
            }
            if(num % 2 == 0){
                num /= 2;
            }

        }
        return true;
    }

}
