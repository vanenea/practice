package com.chen.practice;

import java.util.EnumMap;

enum SecurityCategory {

	STOCK(Security.STOCK.class),BOND(Security.BOND.class);
	private Security [] values;
	
	SecurityCategory(Class<? extends Security> security){
		values = security.getEnumConstants();
	}
	
	interface Security{
		enum STOCK implements Security{ SHORT, LONG, MARGIN }
		enum BOND implements Security{ MUNICIPAL, JUNK }
	}
	
	public Security randomSelector() {
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		for (int i=0;i<3;i++) {
			SecurityCategory sc = Enums.random(SecurityCategory.class);
			System.out.println(sc+":"+sc.randomSelector());
		}
		EnumMap<SecurityCategory,String> map = new EnumMap<>(SecurityCategory.class);
		map.put(SecurityCategory.STOCK, "isMy");
		System.out.println("map:");
	}
}
