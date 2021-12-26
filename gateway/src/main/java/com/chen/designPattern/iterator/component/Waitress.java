package com.chen.designPattern.iterator.component;

public class Waitress {

	private MenuComponent allMenu;
	
	public Waitress(MenuComponent allMenu) {
		this.allMenu = allMenu;
	}
	
	public void printMenu(){
		allMenu.print();
	}
}
