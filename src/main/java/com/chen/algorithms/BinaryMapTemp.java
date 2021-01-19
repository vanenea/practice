package com.chen.algorithms;


/**
 * 二份法Map
 * 
 * @author k3762
 * 
 */
public class BinaryMapTemp<Key extends Comparable<Key>, Value> {

	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] values;

	private int size;

	@SuppressWarnings("unchecked")
	public BinaryMapTemp() {
		keys = (Key[]) new Comparable[INIT_CAPACITY];
		values = (Value[]) new Object[INIT_CAPACITY];
	}

	public int rank(Key key) {
		int lo = 0, hi = size - 1;
		while (hi >= lo) {
			int mi = (hi - lo) / 2;
			if (keys[mi].compareTo(key) > 0) {
				hi = mi - 1;
			} else if (keys[mi].compareTo(key) < 0) {
				lo = mi + 1;
			} else {
				return mi;
			}
		}
		return lo;
	}

	public int size() {
		return size;
	}

	public Value get(Key key) {
		if (key == null)
			new RuntimeException("参数异常");
		int n = rank(key);
		if (n < size && key.compareTo(keys[n]) == 0)
			return values[n];
		return values[n];
	}

	public void put(Key key, Value value) {
		if (key == null)
			new RuntimeException("参数异常");
		int n = rank(key);
		// 已经存在的
		if (n < size && key.compareTo(keys[n]) == 0) {
			values[n] = value;
			return;
		}
		if (size == keys.length)
			resize(2 * keys.length);
		for (int i = size; i > n; i--) {
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}
		keys[n] = key;
		values[n] = value;
		size++;
	}

	@SuppressWarnings("unchecked")
	public void resize(int n) {
		if (n < keys.length)
			new RuntimeException("参数有误");
		Key[] keyTemp = (Key[]) new Comparable[n];
		Value[] valueTemp = (Value[]) new Object[n];
		for (int i = 0; i < keys.length; i++) {
			keyTemp[i] = keys[i];
			valueTemp[i] = values[i];
		}
		keys = keyTemp;
		values = valueTemp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BinaryMapTemp [ ");
		for (int i = 0; i < keys.length; i++) {
			sb.append(keys[i] + "=" + values[i] + " ");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		BinaryMapTemp<String, String> bm = new BinaryMapTemp<String, String>();
		bm.put("aaa", "11");
		bm.put("bbb", "222");
		bm.put("aaa", "33");
		System.out.println(bm);
	}
}
