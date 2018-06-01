package com.chen.javaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo implements InvocationHandler {

    private Object object;

    public ProxyDemo(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("invokeMethod()");;
        return method.invoke(object,args);
    }

    public static void main(String[] args) {
        InterfaceDemo demo = (InterfaceDemo) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(),new Class[]{InterfaceDemo.class},new ProxyDemo(new ClassDemo()));
        demo.sayHello();

    }
}
