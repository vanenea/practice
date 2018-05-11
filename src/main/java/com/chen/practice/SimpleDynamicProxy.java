package com.chen.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
	private Object object;
	
	public DynamicProxyHandler(Object object) {
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy:"+proxy.getClass().getSimpleName()+", Method:"+method+", args:" +args );
		if(args!=null)
			for (Object object : args) {
				System.out.println("args:"+object);
			}
		return method.invoke(object, args);
	}
	
}

public class SimpleDynamicProxy {
	
	public static void consumer(Interface proxy) {
		proxy.doSomething();
		proxy.somethingElse("boom");
	}
	
	public static void main(String[] args) {
		RealObject realObject = new RealObject();
		consumer(realObject);
		
		Interface in = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[] {Interface.class}, new DynamicProxyHandler(realObject));
		consumer(in);
	}
	
	
	
}
