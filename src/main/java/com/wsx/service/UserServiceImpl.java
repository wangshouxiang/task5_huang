package com.wsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsx.dao.UserMapper;
import com.wsx.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User selectUserById(Integer userId) {
		return userMapper.selectUserById(userId);
	}
	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
	@Override
	public User selectUserByPhone(Long phone) {
		return userMapper.selectUserByPhone(phone);
	}

}
