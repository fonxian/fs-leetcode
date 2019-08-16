package com.fonxian.leetcode.leetcode011;

/**
 * @author Michael Fang
 * @since 2019-08-07
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        //左边坐标l,右边坐标r
        //左边高度h[l],右边高度h[r]
        //最大面积maxArea = max(h[l],h[r])*(r-l)

        // l < r
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int maxHeight = height[l] < height[r] ? height[l] : height[r];
            int area = maxHeight * (r - l);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

}
