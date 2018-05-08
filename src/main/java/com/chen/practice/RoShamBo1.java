package com.chen.practice;

import java.util.Random;

interface Item{
	Outcome compare(Item it);
	Outcome eval(Paper pa);
	Outcome eval(Scissors sc);
	Outcome eval(Stone st);
}

class Paper implements Item{
	@Override
	public Outcome compare(Item it) {
		return it.eval(this);
	}
	@Override
	public Outcome eval(Paper pa) {
		return Outcome.DRAW;
	}
	@Override
	public Outcome eval(Scissors sc) {
		return Outcome.WIN;
	}
	@Override
	public Outcome eval(Stone st) {
		return Outcome.LOSE;
	}
	@Override
	public String toString() {
		return "Paper";
	}
}

class Scissors implements Item{

	@Override
	public Outcome compare(Item it) {
		return it.eval(this);
	}

	@Override
	public Outcome eval(Paper pa) {
		return Outcome.LOSE;
	}

	@Override
	public Outcome eval(Scissors sc) {
		return Outcome.DRAW;
	}

	@Override
	public Outcome eval(Stone st) {
		return Outcome.WIN;
	}
	@Override
	public String toString() {
		return "Scissors";
	}
	
}
class Stone implements Item{

	@Override
	public Outcome compare(Item it) {
		return it.eval(this);
	}

	@Override
	public Outcome eval(Paper pa) {
		return Outcome.WIN;
	}

	@Override
	public Outcome eval(Scissors sc) {
		return Outcome.LOSE;
	}

	@Override
	public Outcome eval(Stone st) {
		return Outcome.DRAW;
	}
	@Override
	public String toString() {
		return "Stone";
	}
}

public class RoShamBo1 {
	static Random ran = new Random();
	public static Item newItem() {
		switch(ran.nextInt(3)) {
		case 0: return new Stone();
		case 1: return new Paper();
		case 2: return new Scissors();
		default: return null;
		}
	}
	
	public static Outcome match(Item it1,Item it2) {
		return it1.compare(it2);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			Item it1 = newItem();
			Item it2 = newItem();
			Outcome outcome= match(it1, it2);
			System.out.println(it1+" vs. "+it2+": "+outcome);
		}
	}
}
