package com.chen.designPattern.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {
		System.out.println(); 
		try {
			Hello hello = new HelloImpl();
			LocateRegistry.createRegistry(9999);
			Naming.bind("//127.0.0.1:9999/jackMa", hello);
			System.out.println("Server start!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
