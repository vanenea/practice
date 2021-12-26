package com.chen.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {

	private List<MenuItem> menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		addItem("phm&1", "phm&1", true, 12.9);
		addItem("phm&2", "phm&2", false, 12.9);
		addItem("phm&3", "phm&3", true, 18.2);
		addItem("phm&4", "phm&4", false, 12.9);
		addItem("phm&5", "phm&5", true, 132.2);
		addItem("phm&6", "phm&6", true, 112.0);
		addItem("phm&7", "phm&7", false, 2.0);
		addItem("phm&8", "phm&8", true, 15.3);
		addItem("phm&9", "phm&9", true, 7.3);
		addItem("phm&10", "phm&10", false, 8.32);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	public Iterator getMenuItem() {
		return new PancakeIterator(menuItems);
	}
}
