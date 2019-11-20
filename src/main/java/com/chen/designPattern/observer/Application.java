package com.chen.designPattern.observer;

public class Application {

	public static void main(String[] args) {
		NumberSubject subject = new NumberSubject();
		new BinaryObserver(subject);
		new OctalObserver(subject);
		new HexObserver(subject);  
		subject.setState(20);
	}
}
