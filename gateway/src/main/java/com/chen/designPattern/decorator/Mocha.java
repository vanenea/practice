package com.chen.designPattern.decorator;

public class Mocha extends CondimentDecorator {

	Beverage berverage;
	
	public Mocha(Beverage berverage) {
		this.berverage = berverage;
	}
	
	@Override
	public String getDescription() {
		return berverage.getDescription()+", Mocha";
	}

	@Override
	public double cost() {
		return berverage.cost() + 2.00;
	}

	
}
