package com.chen.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NumberSubject {

	private List<Observer> observer = new ArrayList<Observer>();
	
	private int state;
	
	public void addObserver(Observer observer) {
		this.observer.add(observer);
	}

	public void deleteObserver(Observer observer) {
		this.observer.remove(observer);
		
	}

	public void update(float temperature, float humidity) {
		
	}

	public List<Observer> getObserver() {
		return observer;
	}

	public void setObserver(List<Observer> observer) {
		this.observer = observer;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		for (Observer ob : observer) {
			ob.update();
		}
	}

}
