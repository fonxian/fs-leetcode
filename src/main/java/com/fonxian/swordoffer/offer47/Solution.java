package com.fonxian.swordoffer.offer47;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-27
 */
public class Solution {

    public int maxValue(int[][] grid) {

        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];

        int rst = Integer.MIN_VALUE;
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                if(i == 0&&j==0){
                    dp[i][j] = grid[0][0];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1>=0?j-1:0],dp[i-1>=0?i-1:0][j]) + grid[i][j];
                    rst = rst > dp[i][j] ? rst:dp[i][j];
                }
            }
        }

        return dp[x-1][y-1];
    }

}
