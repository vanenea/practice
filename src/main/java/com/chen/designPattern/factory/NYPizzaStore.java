package com.chen.designPattern.factory;

public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza creatPizza(String name) {
		if("NYPizza".equals(name)) {
			return new NYPizza();
		}else return null;
	}

	
}
