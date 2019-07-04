package com.chen.designPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private float temperature;
	private float humidity;
	private List<Observer> observers;
	
	public WeatherData() {
		observers =  new ArrayList<Observer>();
	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void update(float temperature, float humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
		for (Observer observer : observers) {
			observer.update(temperature, humidity);
		}
	}
	
}
