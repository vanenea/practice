package com.chen.designPattern.iterator;

public class Application {

	public static void main(String[] args) {
		DinerMenu dinerMenu = new DinerMenu();
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		
		waitress.getMenu();
	}
}
