package com.fonxian.leetcode.leetcode1160;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2019-08-18
 */
public class Solution {

    public int countCharacters(String[] words, String chars) {
        char[] array = chars.toCharArray();
        List<String> charList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            charList.add(String.valueOf(array[i]));
        }
        for (int i = 0; i < words.length; i++) {
            if (isRight(words[i], charList)) {
                result.add(words[i]);
            }
        }
        int res = 0;
        for (String s : result) {
            res += s.length();
        }
        return res;
    }


    private boolean isRight(String str, List<String> charList) {
        List<String> tempList = new ArrayList<>();
        tempList.addAll(charList);
        char[] array = str.toCharArray();
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < tempList.size(); j++) {
                if (tempList.get(j).equals(String.valueOf(array[i]))) {
                    tempList.remove(j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            flag = false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(s.countCharacters(words, chars));

    }

}
