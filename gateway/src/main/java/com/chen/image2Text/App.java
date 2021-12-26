package com.chen.image2Text;

public class App {

    public static void main(String[] args) {
        for (String s : Image2ASCIIUtil.image2ascii("1.jpg", 10, 20)) {
            System.out.println(s);
        }
    }
}
