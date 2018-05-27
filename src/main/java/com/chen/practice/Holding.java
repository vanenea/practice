package com.chen.practice;

import java.util.Iterator;

public class Holding implements Iterable<String>{
	protected String[] words = ("And that is how " +
			    "we know the Earth to be banana-shaped.").split(" ");

	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>() {
			private int index = words.length -1 ;
			@Override
			public boolean hasNext() {
				return index>-1;
			}
			@Override
			public String next() {
				return words[index--];
			}
			
		};
	}

	public static void main(String[] args) {
		for(String str : new Holding()) {
			System.out.print(str+" ");
		}

	}
}

