package com.chen.designPattern.observer;

public class Application {

	public static void main(String[] args) {
		NumberSubject subject = new NumberSubject();
		BinaryObserver bo = new BinaryObserver(subject);
		OctalObserver oo = new OctalObserver(subject);
		HexObserver ho = new HexObserver(subject);  
		subject.setState(20);
	}
}
