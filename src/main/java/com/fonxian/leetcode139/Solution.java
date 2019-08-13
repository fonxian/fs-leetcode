package com.fonxian.leetcode139;

import java.util.ArrayList;
import java.util.List;

/**
 * 0 1 2 3 4 5 6 7
 * l e e t c o d e
 * <p>
 * 状态定义
 * 以dp[i]是以s[i]结尾的字符串，是否能由dict中的字符串拼接而成，0不可以，1可以
 * <p>
 * 第一步
 * dp[3] = dict.contain(s[0]+s[1]+s[2]+s[3])
 * s[i]为当前值
 * dp[1] = dict.contain(s[0]+s[1])
 * dp[2] = dict.contain(s[0]+s[1]+s[2])
 * dp[3] = dict.contain(s[0]+s[1]+s[2]+s[3]) = true
 * d[4] = dict.contain(s[4])
 * d[5] = dict.contain(s[4]+s[5])
 * <p>
 * 初始化
 * dp[0-n] = false;
 * <p>
 * 动态方程
 * int index = 0;
 * for(int i = index+1;i<=n;i++)
 * s = s + s[n]
 * dp[n] = dict.contain(s)
 * if(dp[n] == true){
 * index = n;
 * }
 *
 * @author Michael Fang
 * @since 2019-08-13
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        char[] charArray = s.toCharArray();
        int index = -1;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            String tempStr = "";
            for (int j = index + 1; j < len; j++) {
                tempStr += charArray[j];
                if (wordDict.contains(tempStr)) {
                    index = j;
                    dp[j] = true;
                    break;
                } else {
                    dp[j] = false;
                }
            }
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {


        //7
        // 3 4   //3 3
        // 2 3   // 2 2 2

//        String s = "abcd";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("a");
//        wordDict.add("abc");
//        wordDict.add("b");
//        wordDict.add("cd");
//
//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");

        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }

}
