package com.chen.algorithms;

public class FixedCapacityStackOfStrings {

	private String[] a;
	private int N;
	
	public FixedCapacityStackOfStrings(int capacity) {
		a = new String[capacity];
	}
	
	public int size() {
		return N;
	}
	
	public String push(String str) {
		a[N++] = str;
		return str;
	}
	
	public String pop() {
		return a[--N];
	}
}
