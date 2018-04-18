package com.chen.service;

import com.chen.domain.User;

public interface IUserService {
	
	User findUserById(Integer id);
	
	Integer insertUser(User user);
}
