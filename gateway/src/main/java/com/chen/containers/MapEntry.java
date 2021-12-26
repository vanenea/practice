package com.chen.containers;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V result = this.value;
        this.value = value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof MapEntry)) return false;
        MapEntry me = (MapEntry)o;
        return
            (key == null ?
                    me.getKey() == null : key.equals(me.getKey())) &&
                    (value == null ?
                            me.getValue()== null : value.equals(me.getValue()));
    }

    @Override
    public int hashCode() {
        return (key==null?0:key.hashCode()) ^ (value==null?0:value.hashCode());
    }

    //^ 异或运算符 相同的则为1，不通的则为0
    public static void main(String[] args) {
        System.out.println(3^2);
    }

    public static boolean test(){
        return true && false;
    }
}
