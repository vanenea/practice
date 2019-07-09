package com.chen.designPattern.factory;

public class Application {
	public static void main(String[] args) {
		PizzaStore pizzaStore = new NYPizzaStore();
		pizzaStore.orderPizza("NYPizza");
		
	}
}
