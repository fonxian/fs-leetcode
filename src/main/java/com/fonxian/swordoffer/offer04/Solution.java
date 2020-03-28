package com.fonxian.swordoffer.offer04;

/**
 *
 * 面试题04. 二维数组中的查找
 *
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 给定 target = 5，返回 true。

 给定 target = 20，返回 false。


 Consider the following matrix:
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]


 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-16
 */
class Solution {

    /**
     * 解法一：全局遍历
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0){
            return false;
        }
        int column = matrix[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法二：
     *
     * TODO
     *
     * 如果要找26最优的路线：1 -> 15 -> 30 -> 26
     * 如果要找23最优的路线：1 -> 15 ->
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

        return false;
    }



}
