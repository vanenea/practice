package com.chen.designPattern.iterator;

public class DinerMenu {

	static final int MAX_ITEMS = 6;
	private int numberOfItems = 0;
	private MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("dm&1", "dm&1", true, 12.9);
		addItem("dm&2", "dm&2", false, 12.9);
		addItem("dm&3", "dm&3", true, 18.2);
		addItem("dm&4", "dm&4", false, 12.9);
		addItem("dm&5", "dm&5", true, 132.2);
		addItem("dm&6", "dm&6", true, 112.0);
		
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if(numberOfItems<MAX_ITEMS ) {
			menuItems[numberOfItems] = menuItem;
			numberOfItems ++;
		} else {
			System.err.println("Sorry , The menu is full !");
		}
	}
	
	public Iterator getMenu() {
		return new DinerIterator(menuItems);
	}
}
