package com.chen.designPattern.iterator;

public class Waitress {

	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;
	
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	public void getMenu() {
		
		Iterator dinerIterator = dinerMenu.getMenu();
		
		
		Iterator packeHouseIterator = pancakeHouseMenu.getMenuItem();
		
		System.out.println("dinerMenu:");
		while(dinerIterator.hasNext()) {
			MenuItem menuItem = (MenuItem) dinerIterator.next();
			System.out.println(menuItem);
		}
		
		System.out.println("packeHouseMenu:");
		while(packeHouseIterator.hasNext()) {
			MenuItem menuItem = (MenuItem) packeHouseIterator.next();
			System.out.println(menuItem);
		}
	}
	
	public void getMenu(Iterator iterator) {
		while(iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem);
		}
	}
	
}
