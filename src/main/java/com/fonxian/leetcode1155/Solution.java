package com.fonxian.leetcode1155;

/**
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
 * <p>
 * target = t，假设t=7，骰子数m=2,面值k(1-6),总共有组合方法f[2][7]
 * 最后一步：假设有f[2][7] = f[2][7] + f[2-1][7*1-k]
 * 若第1颗骰子,面值为k，则f[2][7] = f[2-1][7*1-k] = f[1][7-k]
 * <p>
 * 当前面值k=1，f[1][6] = 0
 * 当前面值k=1，f[1][2] = 0
 * 当前面值k=1，f[1][1] = 1
 * 当前面值k=2,f[1][2] = 1
 * 当前面值k=6,f[1][6] = 1
 * 当前面值k=1,f[2][1] = f[1][0]=0
 * 当前面值K=1,f[2][2]=f[1][1]= 1
 * 当前面值k=2,f[2][2]=f[2][0] = 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 假设d = 5,f = 5,target = 5
 * 则最后一步：f[5][5] = f[4][5*5-k] = f[4][25-k]
 * <p>
 * <p>
 * k
 * <p>
 * 子问题：
 *
 * @author Michael Fang
 * @since 2019-08-11
 */
public class Solution {

    public int numRollsToTarget(int d, int f, int target) {

        int[][] dp = new int[31][1001];
        //初始化条件，只有1个骰子的时候，1-f的方法均只有1种
        for (int i = 1; i <= f; i++) {
            dp[1][i] = 1;
        }
        //骰子数
        for (int i = 2; i <= d; i++) {
            //要凑出的面值
            for (int j = 1; j <= target; j++) {
                //骰子面值
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] += dp[i - 1][j - k];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        return dp[d][target];

    }

//    public int numRollsToTarget(int d, int f, int target) {
//        //[骰子数][目标值]
//        int[][] dp = new int[31][1001];
//        dp[0][0] = 1;
//        //骰子数
//        for (int i = 1; i <= d; i++) {
//            //面值
//            for (int k = 1; k <= f; k++) {
//                for (int j = 1; j <= f * d; j++) {
//                    if (j >= k) {
//                        dp[i][j] += dp[i - 1][j - k];
//                        System.out.println("骰子数i=" + i + " ,要凑的骰子数之和j=" + j + " ,当前骰子面值k=" + k + " ,dp[骰子数][要凑的骰子数之和]  = dp[" + i + "][" + j + "]=" + dp[i][j] + " ,dp[" + (i - 1) + "][" + (j - k) + "]:" + dp[i - 1][j - k] + "");
//                        dp[i][j] %= 1000000007;
//                    }
//                }
//            }
//        }
//        return dp[d][target];
//    }

    public static void main(String[] args) {
        //d = 2, f = 6, target = 7
        //6
        //1,2,3,4,5,6
        //[1,6]，[2,5],[3,4],[4,3],[5,2],[6,1]


        //d = 3, f=6,target = 7
        //6
        //1,2,3,4,5,6
        //[1,6]，[2,5],[3,4],[4,3],[5,2],[6,1]

        Solution s = new Solution();
        System.out.println(s.numRollsToTarget(2, 6, 7));
    }

}
