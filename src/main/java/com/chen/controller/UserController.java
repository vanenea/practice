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
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
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
	/*static {
		System.out.println("static>>>>>>>");
		System.out.println(userMapper);
	//	System.out.println(userMapper.findAll());
	}*/

	
	@RequestMapping("/showUser")
	@ResponseBody
	public String showUser() {
		User user = new User();
		user.setId(1);
		return userService.showUser(user).toString();
	}
}
