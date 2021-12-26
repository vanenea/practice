package com.chen.practice;

public class TestVolatile {

	private volatile int inc = 0 ;
	
	public void incre() {
		inc++;
	}
	
	public static void main(String[] args) {
		final TestVolatile test = new TestVolatile();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<1000;i++) {
						test.incre();
					}
				}
			}).start();
		}
		
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println(test.inc);
	}
}
