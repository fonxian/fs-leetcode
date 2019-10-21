package com.fonxian.leetcode.leetcode5231;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/weekly-contest-159/problems/remove-sub-folders-from-the-filesystem/
 *
 * @author Michael Fang
 * @since 2019-10-20
 */
@SuppressWarnings("all")
public class Solution {

    public List<String> removeSubfolders(String[] folder) {
        List<String> subStr = new ArrayList<>();
        List<String> res = new ArrayList<>();
        Arrays.sort(folder, (a, b) -> {return a.length() - b.length();});
        for(int i = 0;i<folder.length;i++){
            for(int j = i+1;j<folder.length;j++){
                if(folder[j].startsWith(folder[i]+"/") && !folder[j].equals(folder[i])){
                    subStr.add(folder[j]);
                }
            }
        }
        for(int i = 0;i<folder.length;i++){
            if(!subStr.contains(folder[i])){
                res.add(folder[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] demo1 = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        String[] demo2 = {"/a","/a/b/c","/a/b/d"};
        String[] demo3 = {"/a/b/c","/a/b/d","/a/b/ca"};
        String[] demo4 = {"/ah/al/am","/ah/al"};
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo1)));
        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo2)));
        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo3)));
        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo4)));
    }

}
