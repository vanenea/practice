package com.chen.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.domain.User;
import com.chen.mapper.UserMapper;
import com.chen.service.IUserService;

@Controller
public class UserController {
	
	private static IUserService userService;
	
	public static IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		UserController.userService = userService;
	}

	@Autowired
	private static UserMapper userMapper;
	
	
	
	public void setUserMapper(UserMapper userMapper) {
		UserController.userMapper = userMapper;
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public User findUserById(Integer id) {
		System.out.println("user>>>>>>");
		return userService.findUserById(id);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Integer inserUser(User user) {
		System.out.println("插入数据");
		return userService.insertUser(user);
	}
	
	static {
		System.out.println("static>>>>>>>");
		System.out.println(userMapper);
	//	System.out.println(userMapper.findAll());
	}
}
