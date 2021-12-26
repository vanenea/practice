package com.chen.designPattern.observer;

public abstract class Observer {

	protected NumberSubject subject;
	
	abstract void update();
}
