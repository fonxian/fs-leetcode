package com.fonxian.leetcode.leetcode1029;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/contest/weekly-contest-133/problems/two-city-scheduling/
 *
 * [[10,20],[30,200],[400,50],[30,20]]
 *
 * [[10,20],[30,200],[400,50],[30,20]],[30,20]],[30,20]]
 *
 *
 * @author Michael Fang
 * @since 2019-09-17
 */
public class Solution {

    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
        return total;
    }

}
