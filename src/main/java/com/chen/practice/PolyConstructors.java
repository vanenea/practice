package com.chen.practice;

class Super{
	
	public void draw() {
		System.out.println("super draw");
	}
	Super(){
		System.out.println("super constructors");
		draw();
	}
}

public class PolyConstructors extends Super {
	
	private int radio = 1;
	
	public PolyConstructors(int radio) {
		this.radio = radio;
		System.out.println("polyConstructors constructor");
	}

	public void draw() {
		System.out.println("ployConstructors draw "+radio);
	}

	public static void main(String[] args) {
		Super sup = new PolyConstructors(9);
		sup.draw();
	}
	
	
}
