package com.fonxian.leetcode.leetcode5356;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/weekly-contest-180/problems/lucky-numbers-in-a-matrix/
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-15
 */
public class Solution {

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        OK:
        for (int i = 0; i < matrix.length; i++) {
            // 找到所有行中最小的元素
            int min = Integer.MAX_VALUE;
            int minColumnIndex = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minColumnIndex = j;
                }
            }
            // 找到所有列中最大的
            for (int k = 0; k < matrix.length; k++) {
                if (k == i) {
                    continue;
                }
                if (matrix[k][minColumnIndex] > min) {
                    continue OK;
                }
            }
            rst.add(min);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
//        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
//        int[][] matrix = {{7, 8}, {1, 2}};

        List<Integer> rst = luckyNumbers(matrix);
        rst.forEach(System.out::println);
    }

}
