package com.chen.designPattern.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

	private static final long serialVersionUID = -6783272536705680502L;

	protected HelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello(User user) throws RemoteException {
		return user.getName() + ": Say hello";
	}

}
