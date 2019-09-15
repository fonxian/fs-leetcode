package com.fonxian.leetcode.leetcode5189;

/**
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2019-09-15
 *
 */
public class Solution {

    public int maxNumberOfBalloons(String text) {
        //0 a
        //1 b
        //2 l  2
        //3 o  2
        //4 n
        int[] arr = new int[5];
        char[] charArray = text.toCharArray();
        for(char ch:charArray){
            if(ch == 'a'){
                arr[0]++;
            }
            if(ch == 'b'){
                arr[1]++;
            }
            if(ch == 'l'){
                arr[2]++;
            }
            if(ch == 'o'){
                arr[3]++;
            }
            if(ch == 'n'){
                arr[4]++;
            }
        }
        int res = -1;
        for(int i = 0;i<5;i++){
            if(i == 2 || i == 3){
                res = arr[i]/2 > res && res != -1 ? res:arr[i]/2;
            }else{
                res = arr[i] > res && res != -1? res:arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "nlaebolko";
        Solution solution = new Solution();
        System.out.println(solution.maxNumberOfBalloons(str));
    }

}
