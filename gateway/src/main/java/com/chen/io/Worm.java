package com.chen.io;


import java.io.*;
import java.util.Random;

/**
 * 序列化
 */
class Data implements Serializable {

    private int i;

    public Data(int i) {
        this.i = i;
    }

    public String toString() {
        return Integer.toString(i);
    }

}

public class Worm implements Serializable{

    private static Random r = new Random(47);

    private Data[] data = new Data[]{
            new Data(r.nextInt(10)),
            new Data(r.nextInt(10)),
            new Data(r.nextInt(10))
    };

    private Worm next;
    private char c;

    public Worm(int i,char x){
        System.out.println("Worm Constructor:"+i);
        this.c = x;
        if(--i>0){
            next = new Worm(i,(char)(x+1));
        }
    }

    public Worm(){
        System.out.println("default constructor");
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : data)
            result.append(dat);
        result.append(")");
        if (next != null)
            result.append(next);
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Worm worm = new Worm(6,'a');
        System.out.println("w1:"+worm);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("worm.out"));
        oos.writeObject(worm);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("worm.out"));
        Worm w = (Worm) ois.readObject();
        System.out.println("w2:"+w);

        ByteArrayOutputStream b1 = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(b1);
        oos2.writeObject(worm);
        oos2.flush();
        ObjectInputStream ois2 = new ObjectInputStream(new ByteArrayInputStream(b1.toByteArray()));
        Worm w2 = (Worm) ois2.readObject();
        System.out.println("w3:"+w2);
    }
}
