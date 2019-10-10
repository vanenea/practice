package com.chen.designPattern.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

	public String sayHello(User user) throws RemoteException;
}
