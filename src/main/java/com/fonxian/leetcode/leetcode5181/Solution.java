package com.fonxian.leetcode.leetcode5181;

/**
 * 5181. 公交站间的距离
 * https://leetcode-cn.com/contest/weekly-contest-153/problems/distance-between-bus-stops/
 *
 * AC
 * @author Michael Fang
 * @since 2019-09-08
 */
public class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int res = 0;
        int len = distance.length;

        int i = start;
        do {
            res += distance[i];
            i++;
            if (i > len - 1) {
                i = 0;
            }
        } while (i != destination);


        int tmp = 0;
        int j = destination;
        do {
            tmp += distance[j];
            j++;
            if (j > len - 1) {
                j = 0;
            }
        } while (j != start && j != destination);


        return res < tmp ? res : tmp;
    }

    public static void main(String[] args) {
//        int[] distance = {1, 2, 3, 4};
        int[] distance = {7,10,1,12,11,14,5,0};// 7 2
        int start = 7;
        int destination = 2;
        Solution solution = new Solution();
        int res = solution.distanceBetweenBusStops(distance, start, destination);
        System.out.println(res);
    }
}
