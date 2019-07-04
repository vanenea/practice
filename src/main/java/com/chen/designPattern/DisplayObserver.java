package com.chen.designPattern;

public class DisplayObserver implements Observer {

	private WeatherData weatherData;
	
	public DisplayObserver(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}
	
	@Override
	public void update(float temperature, float humidity) {
		System.out.println("display: temperature is " + temperature +" and humidity is " + humidity);
	}

}
