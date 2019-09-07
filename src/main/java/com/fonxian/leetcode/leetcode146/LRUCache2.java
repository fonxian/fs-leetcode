package com.fonxian.leetcode.leetcode146;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2019-09-08
 */
public class LRUCache2 {

    private List<LRUMap> list = null;
    private int capacity = 0;

    public LRUCache2(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            LRUMap node = (LRUMap) iterator.next();
            if (node.getKey() == key) {
                int value = node.getValue();
                list.remove(node);
                list.add(new LRUMap(key, value));
                return value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        LRUMap node = new LRUMap(key, value);

        //查看该节点是否存在
        if (list.contains(node)) {
            list.remove(node);
        }
        //如果超过容量
        if (list.size() == capacity) {
            list.remove(0);
        }
        list.add(node);

    }

    class LRUMap {

        private int key;
        private int value;

        public LRUMap(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            LRUMap map = (LRUMap) obj;
            return key == map.key;
        }
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
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
