package com.chen.practice;

import java.util.Random;

public class Enums {

	static Random rand = new Random(47);
	
	public static <T extends Enum<T>>T random(Class<T> ec){
		return random(ec.getEnumConstants());
	}

	public static <T>T random(T[] t) {
		return t[rand.nextInt(t.length)];
	}
}

