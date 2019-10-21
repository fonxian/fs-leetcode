package com.fonxian.leetcode.leetcode5231;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/contest/weekly-contest-159/problems/remove-sub-folders-from-the-filesystem/
 *
 * @author Michael Fang
 * @since 2019-10-20
 */
@SuppressWarnings("all")
public class SolutionA {

    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();

        return res;
    }

    public static void main(String[] args) {
//        String[] demo1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
//        String[] demo2 = {"/a", "/a/b/c", "/a/b/d"};
//        String[] demo3 = {"/a/b/c", "/a/b/d", "/a/b/ca"};
//        String[] demo4 = {"/ah/al/am", "/ah/al"};
//        SolutionA solution = new SolutionA();
//        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo1)));
//        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo2)));
//        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo3)));
//        System.out.println(JSONObject.toJSONString(solution.removeSubfolders(demo4)));

        Tries rootNode = new Tries();
        rootNode.setPath("/");
        String a = "/a/b/c/d";
        String[] a1 = a.split("/");



//            System.out.println(p);
//        }

    }

}

class Tries {

    private String path;
    private Map<String, Tries> next;

    public Tries(){

    }
    public Tries(String path, Map<String, Tries> next) {
        this.path = path;
        this.next = next;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Tries> getMap() {
        return next;
    }

    public void setMap(Map<String, Tries> map) {
        this.next = map;
    }

    public void setKey(String key) {
        next.put(key, null);
    }
}
