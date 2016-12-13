package com.wsx.service;

import com.wsx.model.User;

public interface UserService {
	public User selectUserById(Integer userId);
	public User selectUserByPhone(Long phone);
	public void insertUser(User user);
}
