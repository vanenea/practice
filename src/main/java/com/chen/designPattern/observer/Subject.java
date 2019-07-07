package com.chen.designPattern.observer;

public interface Subject {

	void addObserver(Observer observer);
	
	void deleteObserver(Observer observer);
	
	void update(float temperature, float humidity);
	
}
