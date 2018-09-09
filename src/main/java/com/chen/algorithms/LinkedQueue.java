package com.chen.algorithms;

import java.util.Iterator;
/**
 * 队列（链表实现）
 * @author Administrator
 *
 * @param <Item>
 */
public class LinkedQueue<Item> implements Iterable<Item>{

	public Node<Item> first;
	public Node<Item> last;
	public int N;
	
	@SuppressWarnings("hiding")
	private class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		if(last==null) {
			last = first;
		} else {
			oldFirst = first;
		}
		N++;
	}
	
	public Item pop() {
		if(first==null) {
			N=0;
			return null;
		}
		Item i = first.item;
		first = first.next;
		N--;
		return i;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return null;
	}
	
	public static void main(String[] args) {
		LinkedQueue<String> lq = new LinkedQueue<String>();
		lq.push("java");
		lq.push("Vue");
		lq.push("Python");
		System.out.println(lq.pop());
		System.out.println(lq.pop());
		System.out.println(lq.size());
	}
}
