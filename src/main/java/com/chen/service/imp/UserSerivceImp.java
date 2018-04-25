package com.chen.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.domain.User;
import com.chen.mapper.UserMapper;
import com.chen.service.IUserService;

@Service("userService")
public class UserSerivceImp implements IUserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}

	@Override
	public Integer insertUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public List<User> showUser(User user) {
		return userMapper.showUser(user);
	}

}
