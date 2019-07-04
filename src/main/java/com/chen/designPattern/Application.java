package com.chen.designPattern;

public class Application {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		DisplayObserver displayObserver = new DisplayObserver(weatherData);
		displayObserver.update(1515,1232);
	}
}
