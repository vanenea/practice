package com.example.demo;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTests {
	private char[] _UU64 = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] _UU32 = "0123456789abcdefghijklmnopqrstuv".toCharArray();
	@Test
	public void contextLoads() {
		System.out.println(StringUtils.containsAny("asdfsadf", "r","f"));
		long L = UUID.randomUUID().getMostSignificantBits();
        long R = UUID.randomUUID().getLeastSignificantBits();
		//System.out.println("789456");
        System.out.println("l:"+L);
        System.out.println("R:"+R);
        System.out.println("str"+pet(null));
	}

	
	public static String pet(String str) {
		System.out.println("petpet");
		assert str!=null;
		System.out.println("pet");
		System.out.println("petpet");
		return str;
		
	}
	
}
