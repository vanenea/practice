package com.chen.designPattern.iterator;

import java.util.List;

public class PancakeIterator implements Iterator {

	private List<MenuItem> menuItems;
	
	private int position = 0;
	
	public PancakeIterator(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	@Override
	public boolean hasNext() {
		if((position < menuItems.size()) && (menuItems.get(position) != null))
			return true;
		else
			return false;
	}

	@Override
	public Object next() {
		MenuItem menuItem = menuItems.get(position);
		position ++;
		return menuItem;
	}

}
