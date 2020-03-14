package com.fonxian.leetcode.leetcode1025;

/**
 * https://leetcode-cn.com/problems/divisor-game/
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-14
 */
public class Solution {

    public static boolean divisorGame(int N) {
        // dp[3] = dp[2] - max(dp[2] % x == 0 && dp[2] < 3)
        int[] dp = new int[N + 1];
        // alice 0 2 4
        dp[0] = N;
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MIN_VALUE;
            int temp = dp[i - 1];
            // 最佳状态
            // 若最后抽到手里的是2，就赢了
            // 若最后抽到手里的是3，或是1，就输了
            // 所以推断出，若抽到的是偶数，则留给对手一个奇数，等到自己手里就变成偶数
            // 若抽到奇数，操作后得到的数就是偶数，则对手赢
            if (temp % 2 == 0 && temp > 1) {
                dp[i] = temp - 1;
            } else {
                OK:
                for (int x = temp - 1; x > 0; x--) {
                    if (temp % x == 0) {
                        dp[i] = temp - x;
                        break OK;
                    }
                }
            }
            if (dp[i] == Integer.MIN_VALUE) {
                return i % 2 == 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
        System.out.println(divisorGame(4));
    }

}
