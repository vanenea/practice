package com.chen.designPattern.iterator.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {

	private List<MenuComponent> menuComponent = new ArrayList<MenuComponent>();
	private String name;
	private String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void add(MenuComponent menuComponent) {
		menuComponent.add(menuComponent);
	}
	
	public void remove(MenuComponent menuComponent) {
		this.menuComponent.remove(menuComponent);
	}
	
	public MenuComponent getChild(int i) {
		return menuComponent.get(i);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("-----------------------");
		
		Iterator<MenuComponent> iterator = menuComponent.iterator();
		while(iterator.hasNext()) {
			MenuComponent next = iterator.next();
			next.print();
		}
	}
	
	
}
