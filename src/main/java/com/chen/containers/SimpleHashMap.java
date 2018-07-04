package com.chen.containers;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    public static final int SIZE = 997;

    private LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket==null)    continue;
            for (MapEntry<K, V> map: bucket) {
                set.add(map);
            }
        }
        return set;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index]==null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> linkedList = buckets[index];
        MapEntry<K, V> mapEntry = new MapEntry<>(key, value);
        ListIterator<MapEntry<K, V>> iterator = linkedList.listIterator();
        boolean found = false;
        while (iterator.hasNext()){
            MapEntry<K, V> next = iterator.next();
            if(next.getKey().equals(key)){
                found = true;
                oldValue = next.getValue();
                buckets[index].add(next);
                iterator.set(mapEntry);
                break;
            }
        }
        if(!found){
            buckets[index].add(mapEntry);
        }
        return oldValue;
    }


    @Override
    public V get(Object key) {
        return super.get(key);
    }


}
