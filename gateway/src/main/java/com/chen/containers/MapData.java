package com.chen.containers;

import java.util.LinkedHashMap;

public class MapData<K,V> extends LinkedHashMap<K,V> {

    public MapData(Generator<Pair<K,V>> gen, int quantity){
        for (int i = 0; i < quantity; i++) {
            Pair<K,V> pair = gen.next();
            put(pair.key,pair.value);
        }
    }

    public static<K,V> MapData<K,V> map(Generator<Pair<K,V>> gen, int quantity){
        return new MapData(gen,quantity);
    }

}
