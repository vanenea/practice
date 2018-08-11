package com.chen.service;

import java.util.List;

import com.chen.domain.User;

public interface IUserService {
	
	User findUserById(Integer id);
	
	Integer insertUser(User user);
	
	List<User> showUser();
}
