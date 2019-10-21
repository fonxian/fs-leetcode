package com.fonxian.leetcode.leetcode5223;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以攻击国王的皇后
 * https://leetcode-cn.com/contest/weekly-contest-158/problems/queens-that-can-attack-the-king/
 * <p>
 * queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * <p>
 * [[0,1],[1,0],[3,3]]
 * <p>
 * 横坐标相同、纵坐标相同，[i,j]的斜坐标[i+1,j+1]
 * <p>
 * 设王的位置为 x，y
 * <p>
 * 则 可以攻击的位置
 * (x+1,y),(x,y+1)
 * (x-1,y)(x,y-1)
 * (x+1,y+1)(x-1,y-1)
 * (x+1,y-1)(x-1,y+1)
 *
 * @author Michael Fang
 * @since 2019-10-13
 */
public class Solution {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int qLen = queens.length;
        List<List<Integer>> qLists = new ArrayList<>();
        int kX = king[0];
        int kY = king[1];

        //6*6*6 -

        for (int x = 0; x < qLen; x++) {
            if (queens[x][0] == king[0]
                    || queens[x][1] == king[1]
                    || (queens[x][1] - king[1] == queens[x][0] - king[0])) {
                List<Integer> list = new ArrayList<>();
                list.add(queens[x][0]);
                list.add(queens[x][1]);
                qLists.add(list);
            }
        }
        //找到王附近最小的坐标
//        for (List<Integer> l : qLists) {
//            //第一种情况 可以攻击的位置[]
//        }
        int[][] kLocation = {
                {kX + 1, kY}, {kX, kY + 1},
                {kX - 1, kY}, {kX, kY - 1},
                {kX + 1, kY + 1}, {kX - 1, kY - 1},
                {kX + 1, kY - 1}, {kX - 1, kY + 1},
        };
        int[]kk = {0,0,0,0,0,0,0,0};
        //找到上下左右的4个
//        for(int i = kX;i++;i<)
        System.out.println(JSONObject.toJSONString(qLists));
        return null;
    }




    public static void main(String[] args) {
//        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
//        int[] king = {0, 0};

        int[][] queens = {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king = {3,3};

        //[[0,0],[1,1],[2,2],[3,4],[3,5],[4,4]]
        //[[2,2],[3,4],[4,4]]

        Solution solution = new Solution();
        solution.queensAttacktheKing(queens, king);
    }

}
