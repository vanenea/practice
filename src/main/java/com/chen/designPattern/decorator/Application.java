package com.chen.designPattern.decorator;

public class Application {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		
		Mocha mocha = new Mocha(beverage);
		System.out.println(mocha.getDescription()+", total cost: " + mocha.cost());
	}
}
