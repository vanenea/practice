package com.chen.designPattern.observer;

public class BinaryObserver extends Observer {
	
	public BinaryObserver(NumberSubject subject) {
		this.subject = subject;
		subject.addObserver(this);
	}
	
	@Override
	public void update() {
		System.out.println("this's BinaryObserver, The state is " + Integer.toBinaryString(this.subject.getState()));
	}

}
