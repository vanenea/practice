package com.chen.practice;

public class DoSomething {

	public enum Company{
		BOSS{void action(){System.out.println("this is boss");}};
		abstract void action();
	}
	
	public static void main(String[] args) {
		Company[] company = Company.values();
		for (Company company2 : company) {
			company2.action();
		}
	}
}
