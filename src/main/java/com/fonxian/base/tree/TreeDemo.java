package com.fonxian.base.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * 以递归的方式
 *
 * @author Michael Fang
 * @since 2020-02-13
 */
public class TreeDemo {

    private TreeNode root;

    private Queue queue;

    /**
     * 初始化
     */
    void init() {

        //     1
        //   2    3
        //       4  5
        root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
//        node2.left = node4;
        node2.right = node5;
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    void frontLoop(TreeNode root) {
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp != null) {
                System.out.println(tmp.val);
            }
            TreeNode leftTemp = tmp.left;
            while (leftTemp != null) {
                System.out.println(leftTemp.val);
            }
            if (tmp.right != null) {

            }
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    void frontRecursion(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
        }
        if (root != null && root.left != null) {
            frontRecursion(root.left);
        }
        if (root != null && root.right != null) {
            frontRecursion(root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    void middleRecursion(TreeNode root) {
        if (root != null && root.left != null) {
            middleRecursion(root.left);
        }
        if (root != null) {
            System.out.println(root.val);
        }
        if (root != null && root.right != null) {
            middleRecursion(root.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    void backRecursion(TreeNode root) {
        if (root != null && root.left != null) {
            backRecursion(root.left);
        }
        if (root != null && root.right != null) {
            backRecursion(root.right);
        }
        if (root != null) {
            System.out.println(root.val);
        }
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    @SuppressWarnings("all")
    void level(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.val + " ");
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        init();
        System.out.println("前序遍历--------------");
        frontRecursion(root);
        System.out.println("中序遍历--------------");
        middleRecursion(root);
        System.out.println("后序遍历--------------");
        backRecursion(root);
        System.out.println("层次遍历--------------");
        level(root);
    }

    @Test
    public void testHashMap() {
        int initialCapacity = 16;
        int n = initialCapacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n + 1);
    }
}
