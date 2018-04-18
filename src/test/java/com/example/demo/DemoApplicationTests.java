package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(StringUtils.containsAny("asdfsadf", "r","f"));
		//System.out.println("789456");
	}

}
