package com.fonxian.base;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author Michael Fang
 * @since 2020-04-25
 */
public class QiWang {

    public int expectNumber(int[] scores) {
        // 计算和
        int len = scores.length;
        int noReapt = 0;
        Arrays.sort(scores);
        // 获取重复的个数
        List<Integer> list = new ArrayList<>();
        int p = -1;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            int score = scores[i];
            if (p != score) {
                if (temp > 1) {
                    list.add(temp);
                }
                p = score;
                temp = 1;
                if (temp == 1 && i < len - 1 && p != scores[i + 1]) {
                    noReapt++;
                }
            } else {
                temp++;
                if (i == len - 1 && temp > 1) {
                    list.add(temp);
                }
            }
        }
        // 计算最终结果
        // 获取分母
        int fenmu = 2;
        for (Integer i : list) {
            fenmu *= getAnn(i);
        }
        if(list.isEmpty()){
            fenmu = 1;
        }
        System.out.println("分母：" + fenmu);

        // 分子 = 重复的数的个数*sum + 非重复的个数 * (非重复的个数)
        int fenzi = 0;

        System.out.println(noReapt);
        System.out.println(JSONObject.toJSONString(list));

        return 0;
    }

    public int getAnn(int n) {
        int target = 1;
        for (int i = 1; i <= n; i++) {
            target *= i;
        }
        return target;
    }

    public void backtrack(int n,
                          ArrayList<Integer> output,
                          List<List<Integer>> res,
                          int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        QiWang qiWang = new QiWang();
//        System.out.println(JSONObject.toJSONString(qiWang.permute(nums)));
        System.out.println(qiWang.expectNumber(nums));
    }

}
