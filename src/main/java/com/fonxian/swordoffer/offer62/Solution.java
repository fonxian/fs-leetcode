package com.fonxian.swordoffer.offer62;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Michael Fang
 * @since 2020-03-27
 */
public class Solution {

    /**
     * 解法一：超时
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            queue.offer(i);
        }
        int i = 0;
        while(queue.size() > 1){
            int a = queue.poll();
            i++;
            if(i != m){
                queue.offer(a);
            }else{
                i = 0;
            }
        }
        return queue.poll();
    }

    /**
     * 解法二：约瑟夫环
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining2(int n, int m) {
        int p = 0;
        for(int i = 2;i <= n;++i){
            p = (p + m) % i;//约瑟夫环问题公式
        }
        return p;
    }

    /**
     * 解法三：约瑟夫环（递归）
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining3(int n, int m) {
        if(n == 1){
            return 0;
        }
        return (lastRemaining(n-1,m) + m)%n;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(10,17));
    }

}
