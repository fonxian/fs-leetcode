package com.fonxian.leetcode.leetcode200;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author Michael Fang
 * @since 2019-08-20
 */
public class Solution {

    class Position{
        public int x;
        public int y;
        public Position(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        Queue<Position> queue = new ArrayDeque<>();
        //找到所有陆地
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(grid[i][j] == 1){
                    queue.offer(new Position(i,j));
                }
            }
        }
        int[] direct = {0,1,0,-1,0};
        while(!queue.isEmpty()){
            Position position = queue.poll();
            for(int i = 0;i<direct.length;i++){
                int nx = position.x + direct[i];
                int ny = position.y + direct[i+1];
                if(nx > 0 || ny > 0 || nx < N || ny < M || grid[nx][ny] == 2 || grid[nx][ny] == 0){
                    continue;
                }
                grid[position.x][position.y] = 2;

            }

        }
        return 0;

    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        Solution solution = new Solution();
        solution.numIslands(grid);
    }

}
