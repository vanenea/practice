package com.chen.practice;


interface Interface {
	void doSomething();
	
	void somethingElse(String arg);
}

class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("somethingElse "+arg);
	}
	
}

class SimpleProxy implements Interface {

	private Interface prioxied;
	
	public SimpleProxy(Interface prioxied) {
		this.prioxied = prioxied;
	}
	
	@Override
	public void doSomething() {
		System.out.println("Simple");
		prioxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("Simple");
		prioxied.somethingElse(arg);
	}

}

class SimpleProxyDemo {
	public static void consumer(Interface prioxied) {
		prioxied.doSomething();
		prioxied.somethingElse("boom");
	}
	
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
