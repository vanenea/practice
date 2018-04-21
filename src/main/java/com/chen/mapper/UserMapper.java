package com.chen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chen.domain.User;

@Mapper
public interface UserMapper {
	
	User findUserById(Integer id);
	
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);
	
	/**
	 * 找出所有的用户
	 * @return
	 */
	List<User> findAll();
	
}
