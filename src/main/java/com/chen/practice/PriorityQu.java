package com.chen.practice;

import java.awt.List;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQu {
	public static void main(String[] args) {
		Random random = new Random(47);
		PriorityQueue<String> priority = new PriorityQueue<>(Collections.reverseOrder());
		priority.offer("today");
		priority.offer("is");
		priority.offer("a");
		priority.offer("nice");
		priority.offer("day");
		System.out.println(priority);
		
		ao(new LinkedList<String>());
	}
	
	public static String ao(Collection<String> co) {
		return "hello";
	}
}
