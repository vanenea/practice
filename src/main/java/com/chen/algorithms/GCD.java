package com.chen.algorithms;

public class GCD {

	public static int gcd(int p, int q) {
		if(p<0 || q<0){
			throw new RuntimeException("非法参数");
		}
		if(p==0) {
			return q;
		} else if(q==0) {
			return p;
		}
		int r = p % q;
		return gcd(q,r);
	}
	public static void main(String[] args) {
		System.out.println(gcd(377,319));
	}
}
