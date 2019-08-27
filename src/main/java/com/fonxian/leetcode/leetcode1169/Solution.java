package com.fonxian.leetcode.leetcode1169;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * status: AC
 * @author Michael Fang
 * @since 2019-08-25
 */
public class Solution {

    public List<String> invalidTransactions(String[] transactions) {

        List<String> res = new ArrayList<>();
        if (transactions.length == 0) {
            return res;
        }

        Map<String, List<Integer>> map = new HashMap<>();
        int len = transactions.length;
        int[] resArray = new int[len];
        for (int i = 0; i < len; i++) {
            String[] field = transactions[i].split(",");

            //交易金额超过 ¥1000 无效
            if (Integer.valueOf(field[2]) > 1000) {
                resArray[i] = 1;
            }
            //它和另一个城市中同名的另一笔交易相隔不超过 60 分钟
            // 可以理解为其他城市的所有交易
            if (map.get(field[0]) == null) {
                map.put(field[0], new ArrayList<>());
            } else {
                for (int j : map.get(field[0])) {
                    String[] fieldTemp = transactions[j].split(",");
                    // 比较城市名称与相差的时间
                    if (!field[3].equals(fieldTemp[3]) && Math.abs(Integer.valueOf(field[1]) - Integer.valueOf(fieldTemp[1])) <= 60) {
                        resArray[i] = 1;
                        resArray[j] = 1;
                    }
                }
            }
            map.get(field[0]).add(i);
        }

        for (int i = 0; i < len; i++) {
            res.add(transactions[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] str1 = {"alice,20,800,mtv", "alice,50,100,beijing"};
        String[] str2 = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        String[] str3 = {"alice,20,800,mtv", "bob,50,1200,mtv"};
        String[] str4 = {"bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona", "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"};
        String[] str5 = {"alex,676,260,bangkok", "bob,656,1366,bangkok", "alex,393,616,bangkok", "bob,820,990,amsterdam", "alex,596,1390,amsterdam"};
        String[] str6 = {"bob,649,842,prague", "alex,175,1127,mexico", "iris,164,119,paris", "lee,991,1570,mexico", "lee,895,1876,taipei", "iris,716,754,moscow", "chalicefy,19,592,singapore", "chalicefy,820,71,newdelhi", "maybe,231,1790,paris", "lee,158,987,mexico", "chalicefy,415,22,montreal", "iris,803,691,milan", "xnova,786,804,guangzhou", "lee,734,1915,prague", "bob,836,1904,dubai", "iris,666,231,chicago", "iris,677,1451,milan", "maybe,860,517,toronto", "iris,344,1452,bangkok", "lee,664,463,frankfurt", "chalicefy,95,1222,montreal", "lee,293,1102,istanbul", "maybe,874,36,hongkong", "maybe,457,1802,montreal", "xnova,535,270,munich", "iris,39,264,istanbul", "chalicefy,548,363,barcelona", "lee,373,184,munich", "xnova,405,957,mexico", "chalicefy,517,266,luxembourg", "iris,25,657,singapore", "bob,688,451,beijing", "bob,263,1258,tokyo", "maybe,140,222,amsterdam", "xnova,852,330,barcelona", "xnova,589,837,budapest", "lee,152,981,mexico", "alex,893,1976,shenzhen", "xnova,560,825,prague", "chalicefy,283,399,zurich", "iris,967,1119,guangzhou", "alex,924,223,milan", "chalicefy,212,1865,chicago", "alex,443,537,taipei", "maybe,390,5,shanghai", "bob,510,1923,madrid", "bob,798,343,hongkong", "iris,643,1703,madrid", "bob,478,928,barcelona", "maybe,75,1980,shanghai", "xnova,293,24,newdelhi", "iris,176,268,milan", "alex,783,81,moscow", "maybe,560,587,milan", "alex,406,776,istanbul", "lee,558,727,paris", "maybe,481,1504,munich", "maybe,685,602,madrid", "iris,678,788,madrid", "xnova,704,274,newdelhi", "chalicefy,36,1984,paris", "iris,749,200,amsterdam", "lee,21,119,taipei", "iris,406,433,bangkok", "bob,777,542,taipei", "maybe,230,1434,barcelona", "iris,420,1818,zurich", "lee,622,194,amsterdam", "maybe,545,608,shanghai", "xnova,201,1375,madrid", "lee,432,520,dubai", "bob,150,1634,singapore", "maybe,467,1178,munich", "iris,45,904,beijing", "maybe,607,1953,tokyo", "bob,901,815,tokyo", "maybe,636,558,milan", "bob,568,1674,toronto", "iris,825,484,madrid", "iris,951,930,dubai", "bob,465,1080,taipei", "bob,337,593,chicago", "chalicefy,16,176,rome", "chalicefy,671,583,singapore", "iris,268,391,chicago", "xnova,836,153,jakarta", "bob,436,530,warsaw", "alex,354,1328,luxembourg", "iris,928,1565,paris", "xnova,627,834,budapest", "xnova,640,513,jakarta", "alex,119,16,toronto", "xnova,443,1687,taipei", "chalicefy,867,1520,montreal", "alex,456,889,newdelhi", "lee,166,3,madrid", "bob,65,1559,zurich", "alex,628,861,moscow", "maybe,668,572,mexico", "bob,402,922,montreal"};
        String[] str7 = {"bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona", "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"};
        //        s.invalidTransactions(str5);
        String[] str8 = {"bob,175,221,amsterdam", "bob,820,596,bangkok"};
        System.out.println(JSON.toJSONString(s.invalidTransactions(str7)));

    }


}
