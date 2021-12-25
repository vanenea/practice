package com.chen.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class In {

	public Scanner scanner;
	
	@SuppressWarnings("unused")
	private In() {}
	
	public In(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		scanner = new Scanner(file);
	}
	
	public int[] readInt() {
		String[] str = readAll().trim().split("\\s+");
		int[] num = new int[str.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(str[i]);
		}
		return num;
	}
	
	public String readAll() {
		if(!scanner.hasNextLine()) return null;
		return scanner.useDelimiter("\\A").next();
	}
}
