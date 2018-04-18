package com.chen.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chen.configuration.PropertiesConfig;

@Controller
public class Test {

	@Autowired
	private PropertiesConfig propertiesConfig;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping("/test")
	@ResponseBody
	public void tes() {
		System.out.println("propertiesConfig:"+propertiesConfig.getSalt());
		System.out.println("redisTemplate:"+redisTemplate);
		ValueOperations<String, Object> va = redisTemplate.opsForValue();
		String str = (String)va.get("name");
		if(str==null) {
			str = "字符串";
			va.set("name", str,10,TimeUnit.SECONDS);
			
		}
		System.out.println("reids:"+va.get("name"));
		System.out.println(str);
	}
}
