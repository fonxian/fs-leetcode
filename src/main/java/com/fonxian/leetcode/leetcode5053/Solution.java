package com.fonxian.leetcode.leetcode5053;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * href = https://leetcode-cn.com/contest/weekly-contest-150/problems/as-far-from-land-as-possible/
 *
 * @author Michael Fang
 * @since 2019-08-18
 */
public class Solution {

    class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        int[] direction = {0, 1, 0, -1, 0};
        int N = grid.length;
        int res = 0;
        Queue<Position> queue = new ArrayDeque<>();
        //找到陆地
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Position(i, j));
                }
            }
        }
        //全是海洋或陆地
        if (queue.size() == N * N || queue.isEmpty()) {
            return -1;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int r = 0;
            while (size != 0) {
                Position position = queue.poll();
                for (int i = 0; i < direction.length-1; i++) {
                    int nx = position.x + direction[i];
                    int ny = position.y + direction[i + 1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || grid[nx][ny] == 1) {
                        continue;
                    }
                    grid[nx][ny] = 1;
                    queue.offer(new Position(nx, ny));
                    r++;
                }
                size--;
            }
            if(r > 0){
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(grid));

    }

}
