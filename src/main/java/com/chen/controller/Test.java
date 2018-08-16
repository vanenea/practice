package com.chen.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.jms.Destination;

import com.chen.activemq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chen.configuration.PropertiesConfig;

import net.sf.json.JSONArray;

@Controller
public class Test {

	@Autowired
	private PropertiesConfig propertiesConfig;

	@Autowired
	private Producer producer;

	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping("/test1")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/vueDemo")
	public String vueDemo() {
		return "vueDemo";
	}
	
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

	@RequestMapping("/mq")
	@ResponseBody
	public void activeMqTest(){
		Destination destination = new ActiveMQQueue("test.queque");
		for (int i = 0; i < 10; i++) {
			producer.send(destination,"HelloWorld");

		}
	}

}
