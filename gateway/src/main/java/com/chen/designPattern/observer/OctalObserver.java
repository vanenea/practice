package com.chen.designPattern.observer;

public class OctalObserver extends Observer {
	
	public OctalObserver(NumberSubject subject) {
		this.subject = subject;
		subject.addObserver(this);
	}
	
	@Override
	public void update() {
		System.out.println("this's OctalObserver, The state is " + Integer.toOctalString(this.subject.getState()));
	}

}

