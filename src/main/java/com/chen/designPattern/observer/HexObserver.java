package com.chen.designPattern.observer;

public class HexObserver extends Observer {
	
	public HexObserver(NumberSubject subject) {
		this.subject = subject;
		subject.addObserver(this);
	}
	
	@Override
	public void update() {
		System.out.println("this's HexObserver, The state is " + Integer.toHexString(this.subject.getState()));
	}

}