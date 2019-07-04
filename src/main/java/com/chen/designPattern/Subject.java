package com.chen.designPattern;

public interface Subject {

	void addObserver(Observer observer);
	
	void deleteObserver(Observer observer);
	
	void update(float temperature, float humidity);
	
}
