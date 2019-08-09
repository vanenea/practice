package com.chen.designPattern.iterator.component;

public class MenuTestDrive {

	public static void main(String[] args) {
		
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "BREAKFAST");
		MenuComponent dinerMenu = new Menu("DINER MENU", "LUACH");
		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
		MenuComponent dessertMenu = new Menu("DESSERT MENU", "DessertMenu of course");
		MenuComponent allMenu = new Menu("ALL MENU", "all menu");
		
		allMenu.add(pancakeHouseMenu);
		allMenu.add(dinerMenu);
		allMenu.add(dinerMenu);
		allMenu.add(cafeMenu);
		
		
		pancakeHouseMenu.add(new MenuItem("Pasta", "Pasta", true, 9.86));
		
		dinerMenu.add(new MenuItem("aaa", "aaa", false, 6.35));
		cafeMenu.add(new MenuItem("bbb", "bbb", true, 9.36));
		cafeMenu.add(dessertMenu);
		
		
	}
}
