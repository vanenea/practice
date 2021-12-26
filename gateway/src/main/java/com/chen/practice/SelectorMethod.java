package com.chen.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Peter{
	void around1();
	void around2();
	void around3();
}

class PeterJson implements Peter {

	@Override
	public void around1() {
		System.out.println("around1");
	}

	@Override
	public void around2() {
		System.out.println("around2");
	}

	@Override
	public void around3() {
		System.out.println("around3");
	}
	
}

class ProxyDemo implements InvocationHandler {

	private Peter peter;
	
	public ProxyDemo(Peter peter) {
		this.peter = peter;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("around2"))
			System.out.println("this is around2 method!!!");
		Object obj = method.invoke(peter, args);
		return obj;
	}
}

public class SelectorMethod {
	public static void main(String[] args) {
		Peter peter = (Peter) Proxy.newProxyInstance(Peter.class.getClassLoader(), new Class[] {Peter.class}, new ProxyDemo(new PeterJson()));
		peter.around1();
		peter.around2();
		peter.around3();
	}
}
