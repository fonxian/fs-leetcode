package com.fonxian.leetcode.leetcode5191;

/**
 * @author Michael Fang
 * @since 2019-09-15
 * <p>
 * 1，2
 * 1，2，0，-1
 * 1，2，0，-1 ，1，2，0，-1 ，1，2，0，-1
 * <p>
 * <p>
 * -5,-2,0,0,3,9,-2,-5,4  -5,-2,0,0,3,9,-2,-5,4
 * <p>
 * <p>
 * <p>
 * 如果数组最大值 > 数组之和，将数组最大值与数组之和*k相比较
 */
@SuppressWarnings("all")
public class Solution {

    public static int MOD = (int) (1e9 + 7);

    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        long res = 0;
        int len = arr.length;
        int leftMax = 0;
        int rightMax = 0;
        // 统计固定左端点，从左往右最大和
        for (int i = 0, cur = 0; i < len; i++) {
            cur += arr[i];
            leftMax = Math.max(leftMax, cur);
        }
        // 统计固定右端点，从右往左最大和
        for (int i = len - 1, cur = 0; i >= 0; i--) {
            cur += arr[i];
            rightMax = Math.max(rightMax, cur);
        }
        // 最大的子数组
        for (int i = 0, cur = 0; i < len; i++) {
            cur += arr[i];
            if (cur < 0) {
                cur = 0;
            }
            res = Math.max(res, cur);
        }
        //获取数组之和
        for (int t : arr) {
            sum += t;
        }
        if (k == 1) {
            return (int) res % MOD;
        }

        //1.取所有sum
        res = Math.max(res, sum * k);
        //2.只拼接一边之和
        res = Math.max(res, sum * (k - 1) + Math.max(leftMax, rightMax));
        //3.左右最大子串之和
        res = Math.max(res, sum * (k - 2) + leftMax + rightMax);
        //4.sum < 0
        res = Math.max(res, leftMax + rightMax);
        res = res % MOD;
        return (int) res;

    }

    public static void main(String[] args) {
        int arr[] = {-1, 3, 3, -4};

        //-1 , 3, 3, -4,  -1 , 3, 3, -4,  -1, 3, 3, -4
        int k = 4;
        Solution solution = new Solution();
        System.out.println(solution.kConcatenationMaxSum(arr, k));
    }

}
