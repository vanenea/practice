package com.chen.algorithms;

import java.util.Scanner;

/**
 * union-find 简化版
 * @author Administrator
 *
 */
public class UF1 {
	int count;
	int[] id;
	
	/**
	 * 初始化
	 * @param n
	 */
	public UF1(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	/**
	 * 联合
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int pPoint = find(p);
		int qPoint = find(q);
		if(pPoint==qPoint)	return ;
		for (int i = 0; i < id.length; i++) {
			if(id[i]==qPoint) {
				id[i] = pPoint;
			}
		}
		count --;
	}
	
	public int find(int n) {
		return id[n];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UF1 uf = new UF1(scan.nextInt());
		while(scan.hasNext()) {
			int one = scan.nextInt();
			int two = scan.nextInt();
			uf.union(one, two);
			System.out.println(uf.count);
			System.out.println(one+", "+two);
		}
		scan.close();
	}
}
