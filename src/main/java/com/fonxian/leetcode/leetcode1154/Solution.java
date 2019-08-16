package com.fonxian.leetcode.leetcode1154;

/**
 * status: pass
 *
 * @author Michael Fang
 * @since 2019-08-11
 */
public class Solution {

    public static int ordinalOfDate(String date) {
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        int totalDay = 0;
        for (int i = 1; i < month; i++) {
            totalDay += getDay(year, i);
        }
        totalDay += day;
        return totalDay;
    }

    private static int getDay(int year, int month) {
        int[] datyOf12Month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return month == 2 && isLeepYear(year) ? datyOf12Month[month] + 1 : datyOf12Month[month];
    }

    //是否是闰年 是 29天 ，不是 28天
    private static boolean isLeepYear(int year) {
        if (year % 100 == 0) {
            return year % 4 == 0;
        }
        return year % 4 == 0;
    }

    public static void main(String[] args) {
        //9
        String date = "2019-01-09";
        //41
        date = "2019-02-10";
        System.out.println(ordinalOfDate(date));
    }

}
