package com.fonxian.leetcode.leetcode122;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-18
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int rst = 0;
        int len = prices.length;
        if(len == 0){
            return rst;
        }
        int minPrice = Integer.MAX_VALUE;
        for(int i = 1;i< len;i++){
            minPrice = Math.min(minPrice,prices[i-1]);
            if(prices[i] - minPrice > 0){
                rst += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return rst;
    }

}

