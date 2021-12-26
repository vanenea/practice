package com.chen.practice;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>,Integer> {
	private Class<?> baseType;
	
	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}

	public TypeCounter counter(Class<?> cls) {
		put(cls,get(cls)==null?1:get(cls)+1);
		Class<?> sup = cls.getSuperclass();
		if(sup!=null && baseType.isAssignableFrom(cls)) {
			counter(sup);
		}
		return this;
	}
}
