package com.fonxian.leetcode.leetcode5069;

/**
 * 给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 * leetcode
 * 应该返回tcode
 * c、co、cod、code
 * d、de
 * e、ee、eet、eetc、eetco、eetcod、eetcode
 * l、le、lee、leet、leetc、leetco、leetcod、leetcode
 * o、od、ode
 * t、tc、tco、tcod、tcode
 * <p>
 * abab
 * 应该返回bab
 * a、ab、aba、abab
 * b、ba、bab
 * <p>
 * zaazcc
 * 应该返回zcc
 * a、aa、aaz、aazc、aazcc
 * c、cc
 * z、za、zaa、zaaz、zaazc、zaazcc、zc、zcc
 * <p>
 * zzaazcc
 * 应该返回zzaazcc
 * a、aa、aaz、aazc、aazcc
 * c、cc
 * z、za、zaa、zaaz、zaazc、zaazcc、zc、zcc
 * zz、zza、zzaa、zzaa、zzaaz、zzaazc、zzaazcc
 *
 * @author Michael Fang
 * @since 2019-08-18
 */
public class Solution {

    //一开始考虑的是先找到最大字母还有每个字母的位置存进list，
    // 当list.size()!=1的时候对每个位置开始往后找，
    // 然后不停的把小的从list里删掉，后来转换思路从前向后依次对比，
    // 但是需要注意重复直问题，
    // 测试用例中有一个无限长的string全是'a' ->"aaaaaaaaaaaaaaaaaa........." 如果不去重会超时

    public String lastSubstring(String s) {
        //应该截取的字符串的起始位置res = k
        int k = 0;
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        //找到最大字符首先出现位置k
        for (int i = 1; i < len; i++) {
            if (charArray[i] > charArray[k]) {
                k = i;
            }
        }
        //从k开始找到与k相等的字符，比较字符所在位置之后的第一个字符大小
        for (int i = k + 1; i < len; i++) {
            //考虑 zaazzcc的情况，两个相同字符串z出现，取index最小
            if (charArray[i] == charArray[k] && charArray[i] != charArray[i - 1]) {
                for (int j = 1; k + j < i && i+j < len; j++) {
                    if (charArray[k + j] < charArray[i + j]) {
                        k = i;
                        break;
                    }
                    if (charArray[k + j] > charArray[i + j]) {
                        break;
                    }
                }
            }
        }
        return s.substring(k);
    }

    public static void main(String[] args) {
        String str = "zzaazcc";
        str = "abab";
        str = "leetcode";
        Solution solution = new Solution();
        String res = solution.lastSubstring(str);
        System.out.println(res);
    }

}
