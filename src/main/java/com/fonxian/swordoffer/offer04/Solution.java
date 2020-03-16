package com.fonxian.swordoffer.offer04;

/**
 *
 * 面试题04. 二维数组中的查找
 *
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 给定 target = 5，返回 true。

 给定 target = 20，返回 false。

 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-16
 */
class Solution {
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
}
