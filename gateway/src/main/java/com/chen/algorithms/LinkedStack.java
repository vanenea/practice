package com.chen.algorithms;

import java.util.Iterator;

/**
 * 下压堆栈（链表实现）
 * @author Administrator
 *
 * @param <Item>
 */
public class LinkedStack<Item> implements Iterable<Item> {

	public Node<Item> first; 
	public int N;
	
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void push(Item item) {
		Node<Item> oldFist = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFist;
		N++;
	}
	
	public Item pop() {
		Node<Item> n = first.next;
		Item i = first.item;
		first = n;
		N--;
		return i;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<String>();
		System.out.println(ls.isEmpty());
		ls.push("hello");
		ls.push("word");
		ls.push("java");
		ls.push("Vue");
		ls.push("Angular");
		ls.push("PHP");
		ls.push("Python");
		System.out.println(ls.size());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
	}
}
