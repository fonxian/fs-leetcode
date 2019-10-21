package com.fonxian.leetcode.leetcode5230;


/**
 * @author Michael Fang
 * @since 2019-10-20
 */
public class Solution {


    //y = 2*x + 1
    public boolean checkStraightLine(int[][] coordinates) {
        int k = Integer.MIN_VALUE;
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        int dy = y2 - y1;
        int dx = x2 - x1;
        if (dx != 0) {
            k = dy / dx;
        }
        int b = y1 - k * x1;
        boolean onLine = true;
        for (int i = 2; i < coordinates.length; i++) {
            if (k == Integer.MIN_VALUE) {
                if (coordinates[i][0] != x1) {
                    onLine = false;
                    break;
                }
            } else if (coordinates[i][1] != (k * (coordinates[i][0]) + b)) {
                onLine = false;
                break;
            }
        }
        return onLine;
    }

    public static void main(String[] args) {
        int[][] demo1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] demo2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        int[][] demo3 = {{-7, -3}, {-7, -1}, {-2, -2}, {0, -8}, {2, -2}, {5, -6}, {5, -5}, {1, 7}};
        Solution solution = new Solution();
        System.out.println(solution.checkStraightLine(demo1));
        System.out.println(solution.checkStraightLine(demo2));
        System.out.println(solution.checkStraightLine(demo3));
    }

}
