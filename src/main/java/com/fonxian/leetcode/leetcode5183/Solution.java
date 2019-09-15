package com.fonxian.leetcode.leetcode5183;


import java.util.Calendar;

/**
 * 5183. 一周中的第几天
 * https://leetcode-cn.com/contest/weekly-contest-153/problems/day-of-the-week/
 *
 * @author Michael Fang
 * @since 2019-09-08
 */
public class Solution {

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.dayOfTheWeek(31,8,2019));
        System.out.println(solution.dayOfTheWeek(15, 8, 1993));
//        System.out.println(solution.dayOfTheWeek(18,7,1999));
    }

}
