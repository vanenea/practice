package com.chen.algorithms;

/**
 * 链表的实现方式
 * @author k3762
 *
 * @param <K>
 * @param <V>
 */
public class MapTemp<K, V> {

	private Node first;
	
	private int size = 0;

	private class Node {
		private K key;
		private V value;
		private Node next;

		public Node(K key, V value, Node next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", next=" + next
					+ "]";
		}
		
	}

	public V get(K key) {
		if (key == null)
			return null;
		for (Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)){
				return x.value;
			}
		}
		return null;
	}
	
	public void put(K key, V value){
		if(key == null)  new RuntimeException("参数异常");
		for(Node x = first; x != null; x = x.next){
			if(key.equals(x.key)){
				x.value = value;
				return;
			}
		}
		first = new Node(key, value, first);
		size ++ ;
	}
	
	public V delete(K key){
		if(key == null) new RuntimeException("参数异常");
		V value = get(key);
		if(value != null){
			put(key, null);
		}
		return value;
	}
	
	public int size(){
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for(Node x = first; x != null; x = x.next){
			sb.append(x.key + "=" + x.value + " ");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		MapTemp<String, String> map = new MapTemp<String, String>();
		map.put("aaa", "1");
		map.put("aa", "2");
		map.put("bbb", "3");
		map.put("aaa", "4");
		map.delete("aa");
		System.out.println(map);
	}
}
