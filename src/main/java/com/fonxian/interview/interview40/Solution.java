package com.fonxian.interview.interview40;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * <p>
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-20
 */
public class Solution {

    /**
     * 解法1：使用排序问题解决
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    /**
     * 解法2：使用堆解决
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr == null) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>(k, (a, b) -> Integer.compare(b, a));

        for (int a : arr) {
            if (heap.size() < k || a < heap.peek()) {
                heap.offer(a);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] rst = new int[k];
        int index = 0;
        for(int h:heap){
            rst[index++] = h;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(getLeastNumbers2(arr, k)));

    }


}
