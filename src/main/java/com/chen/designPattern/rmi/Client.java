package com.chen.designPattern.rmi;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) {
		try {
			Hello hello = (Hello) Naming.lookup("//127.0.0.1:9999/wbh");
			User user = new User();
			user.setName("Tommy");
			hello.sayHello(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
