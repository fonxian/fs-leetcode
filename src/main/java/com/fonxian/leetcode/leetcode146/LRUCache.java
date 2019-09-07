package com.fonxian.leetcode.leetcode146;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author Michael Fang
 * @since 2019-09-05
 */
public class LRUCache {

    private Map<Integer, Integer> map = null;
    private List<HitCount> list = null;
    private Map<Integer, HitCount> locationMap = null;
    private int index = 0;
    private int capacity = 0;


    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        list = new LinkedList<>();
        locationMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        //先找到key-value
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }

        HitCount h = locationMap.get(key);
        h.setCount(++index);
        return value;
    }

    public void put(int key, int value) {
        //若key已存在
        Integer existValue = map.get(key);
        //容量不充足
        if (existValue == null && map.size() == capacity) {
            //找到命中次数最少的一个、若命中次数相同，则去除插入最早的
            HitCount leastKey = getLeastKey();
            map.remove(leastKey.getKey());
            list.remove(leastKey);
            locationMap.remove(leastKey.getKey());
        }
        HitCount h = null;
        if (existValue != null) {
            h = locationMap.get(key);
            h.setCount(++index);
        } else {
            h = new HitCount(key, ++index);
            list.add(h);
        }
        map.put(key, value);
        locationMap.put(key, h);
        index++;
    }


    private HitCount getLeastKey() {
        list = list.stream().sorted((u1, u2) -> (u1.getCount() - u2.getCount())).collect(Collectors.toList());
        return list.get(0);
    }


    class HitCount {
        private int key;
        private int count;

        HitCount(int key, int count) {
            this.key = key;
            this.count = count;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

}
