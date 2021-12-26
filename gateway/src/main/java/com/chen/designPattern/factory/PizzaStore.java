package com.chen.designPattern.factory;

public abstract class PizzaStore {

	public Pizza orderPizza(String name) {
		Pizza pizza = creatPizza(name);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	
	public abstract Pizza creatPizza(String name);
}
