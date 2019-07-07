package com.chen.designPattern.decorator;

/**
 * 装饰者模式
 * @author Chen.Y
 *
 */
public abstract class Beverage {

	String description = "Unknown Beverage";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
