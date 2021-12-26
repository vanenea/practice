package com.chen.containers;

import java.util.Random;

public class RandomGenerator {

    static private Random r = new Random(47);
    static char[] ch = ("abcdefghijklmnopqrstuvwxyz"+"ABCDEFGHIJKLMNOPKRSTUVWXYZ").toCharArray();

    public static class String implements Generator<java.lang.String>{
        private int length = 7;
        public String(int length){
            this.length = length;
        }

        public char createChar(){
            return ch[r.nextInt(ch.length)];
        }

        @Override
        public java.lang.String next() {
            char[] chas = new char[length];
            for (int i = 0; i < length; i++) {
                chas[i] = createChar();
            }
            return new java.lang.String(chas);
        }
    }
}
