package com.fonxian.leetcode.leetcode139;

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
 * flag1
 * flag2
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
 * <p>
 * c a t s a n d o g
 * 0 1 2 3 4 5 6 7 8
 * F F T T F F T F F
 * <p>
 * 第一步
 * s[0] = dict.contain(s[0]) = false
 * s[1] = dict.contain(s[0,1]) = false
 * s[2] = dict.contain(s[0,2]) = true
 * s[3] = dict.contain(s[0,2] + s[3,3]) || dict.contain(s[3,3]) = true
 * s[4] = dict.contain(s[0,3] + s[4,4]) || dict.contain(s[4,4]) = false
 * s[5] = dict.contain(s[2,5]) || dict.contain(3,5) = false
 * s[6] = dict.contain(s[2,6]) || dict.contain(3,6) = true
 *
 * @author Michael Fang
 * @since 2019-08-13
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            if (wordDict.contains(s.substring(0, i))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
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
//
//        String s = "aaaaaa";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("aaaa");
//        wordDict.add("aaa");

//        String s = "catsandog";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }

}
