package com.chen.practice;

/**
 * 线程的三大特性
 * 1.原子性
 * 2.可见性
 * 3.有序性
 */
public class ThreadDemo{

    //volatile变量的可见性
    private volatile int i = 0;

    public void plus() {
        i++;
    }

    /**
     * 无法保证原子性
     * @param args
     */
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        for(int i=0; i<1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.plus();
                }
            }).start();
        }
        System.out.println("i:"+threadDemo.i);
    }
}
