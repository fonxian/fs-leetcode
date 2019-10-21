package com.fonxian.leetcode.leetcode5231;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author Michael Fang
 * @since 2019-10-20
 */
public class TreeTest {

    public Tree rootNode = null;

    @SuppressWarnings("all")
    public List<String> removeSubfolders(String[] folder) {

        rootNode = new Tree();
        rootNode.path = "/";
        rootNode.nextMap = new HashMap<>();

        List<String> res = new ArrayList<>();
        Arrays.sort(folder, (a, b) -> {
            return a.length() - b.length();
        });
        for (int i = 0; i < folder.length; i++) {
            if (!isCover(folder[i])) {
                res.add(folder[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeTest test = new TreeTest();
        String[] demo1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        String[] demo2 = {"/a", "/a/b/c", "/a/b/d"};
        String[] demo3 = {"/a/b/c", "/a/b/d", "/a/b/ca"};
        String[] demo4 = {"/ah/al/am", "/ah/al"};
        System.out.println(JSONObject.toJSONString(test.removeSubfolders(demo1)));
        System.out.println(JSONObject.toJSONString(test.removeSubfolders(demo2)));
        System.out.println(JSONObject.toJSONString(test.removeSubfolders(demo3)));
        System.out.println(JSONObject.toJSONString(test.removeSubfolders(demo4)));


    }

    /**
     * 创建树
     */
    @SuppressWarnings("all")
    public void createTree(String path) {
        String[] pathArray = path.split("/");
        int arrayLen = pathArray.length;
        //初始化根节点
        if (rootNode == null) {
            rootNode = new Tree();
            rootNode.path = "/";
            rootNode.nextMap = new HashMap<>();
        }
        Tree tmp = rootNode;
        for (int i = 1; i < arrayLen; i++) {
            Tree node = tmp.nextMap.get(pathArray[i]);
            if (node == null) {
                node = new Tree();
                node.path = pathArray[i];
                node.nextMap = new HashMap<>();
            }

            tmp.nextMap.put(pathArray[i], node);
            tmp = node;

        }

    }

    /**
     * 判断文件路径是否被包含
     * @param path
     * @return
     */
    @SuppressWarnings("all")
    public boolean isCover(String path) {
        boolean cover = false;
        String[] pathArray = path.split("/");
        int arrayLen = pathArray.length;

        Tree tmp = rootNode;
        for (int i = 1; i < arrayLen; i++) {
            Tree node = tmp.nextMap.get(pathArray[i]);
            if (node == null) {
                node = new Tree();
                node.path = pathArray[i];
                node.nextMap = new HashMap<>();
            } else {
                if (node.isRoot) {
                    cover = true;
                }
            }
            if (cover == false && i == arrayLen - 1) {
                node.isRoot = true;
            }
            tmp.nextMap.put(pathArray[i], node);
            tmp = node;
        }
        return cover;
    }

    /**
     * 遍历树
     *
     * @param node
     */
    public void traversalTree(String key, Tree node) {
        if (key != "/") {
            System.out.println(key);
        }
        if (node.nextMap != null) {
            for (Map.Entry<String, Tree> entry : node.nextMap.entrySet()) {
                if (entry.getValue() != null) {
                    if (key != "/") {
                        traversalTree(key + "/" + entry.getKey(), entry.getValue());
                    } else {
                        traversalTree(key + entry.getKey(), entry.getValue());
                    }
                }
            }

        }
    }
}

class Tree {
    public String path;
    public boolean isRoot;
    public Map<String, Tree> nextMap;
}
