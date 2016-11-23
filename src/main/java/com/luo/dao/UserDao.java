package com.luo.dao;

import org.apache.ibatis.annotations.Select;

import com.luo.domain.User;

public interface UserDao {
	@Select("SELECT user_id as userId,user_name as userName,"
			+ "user_password as userPassword FROM t_user WHERE USER_ID = #{userId}")
	public User selectUserById(Integer userId);
}
