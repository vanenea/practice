package com.chen.containers;

public class MapDataTest implements Generator<Pair<Integer,Character>> {

    private int num = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer,Character> next() {
        return new Pair<Integer,Character>(num++,letter++);
    }

    public static void main(String[] args) {
        System.out.println(MapData.map(new MapDataTest(),9));
    }

}
