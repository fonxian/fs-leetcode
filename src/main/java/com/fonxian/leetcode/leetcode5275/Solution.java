package com.fonxian.leetcode.leetcode5275;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * AC
 *
 *
 * @author Michael Fang
 * @since 2019-12-01
 */
public class Solution {

    private Set<String> aSet = new HashSet<>();
    private Set<String> bSet = new HashSet<>();


    public String tictactoe(int[][] moves) {

        // 如果A小于3，且B小于3，则返回Pending
        // A和B任意一方赢，只能有8种方式
        for (int i = 0; i < moves.length; i++) {
            String location = moves[i][0] + ":" + moves[i][1];
            if (i % 2 == 0) {
                aSet.add(location);
            } else {
                bSet.add(location);
            }
        }

        boolean aWin = isWin(aSet);
        boolean bWin = isWin(bSet);
        if (aWin) {
            return "A";
        }
        if (bWin) {
            return "B";
        }
        if (aSet.size() + bSet.size() == 9) {
            return "Draw";
        }
        return "Pending";
    }

    private boolean isWin(Set<String> set) {
        if (set.contains("0:0") && set.contains("1:1") && set.contains("2:2")) {
            return true;
        }
        if (set.contains("0:2") && set.contains("1:1") && set.contains("2:0")) {
            return true;
        }
        int count_x_0 = 0;
        int count_x_1 = 0;
        int count_x_2 = 0;

        int count_y_0 = 0;
        int count_y_1 = 0;
        int count_y_2 = 0;

        for (String s : set) {
            String[] t = s.split(":");
            int x = Integer.valueOf(t[0]);
            int y = Integer.valueOf(t[1]);
            if (x == 0) {
                count_x_0++;
            }
            if (x == 1) {
                count_x_1++;
            }
            if (x == 2) {
                count_x_2++;
            }
            if (y == 0) {
                count_y_0++;
            }
            if (y == 1) {
                count_y_1++;
            }
            if (y == 2) {
                count_y_2++;
            }
            if (count_x_0 >= 3 || count_x_1 >= 3 || count_x_2 >= 3) {
                return true;
            }
            if (count_y_0 >= 3 || count_y_1 >= 3 || count_y_2 >= 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
//        int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
//        int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        int[][] moves = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};

        Solution solution = new Solution();
        System.out.println(solution.tictactoe(moves));
    }

}
