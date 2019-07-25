package com.chen.designPattern.iterator;

public class DinerIterator implements Iterator {
	
	private MenuItem[] menuItems;
	private int position = 0;
	public DinerIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
	
	@Override
	public boolean hasNext() {
		if((position < menuItems.length) && (menuItems[position] != null))
			return true;
		else
			return false;
	}

	@Override
	public Object next() {
		MenuItem menuItem = menuItems[position];
		position ++;
		return menuItem;
	}

}
