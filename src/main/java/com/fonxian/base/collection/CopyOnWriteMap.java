package com.fonxian.base.collection;

import java.util.*;

/**
 * @author Michael Fang
 * @since 2019-11-07
 */
public class CopyOnWriteMap<K,V> implements Map<K,V>{


    private  volatile Map<K,V> internalMap  = null;

    public CopyOnWriteMap() {
        this.internalMap = new HashMap<K, V>(100);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        synchronized (this){
            Map<K,V> newMap = new HashMap<K, V>(internalMap);
            V val = newMap.put(key,value);
            //产生一个只读的Map
            internalMap = Collections.unmodifiableMap(newMap);
            return val;
        }
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
