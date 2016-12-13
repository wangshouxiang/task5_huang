package com.wsx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.wsx.model.User;

public interface UserMapper {
	@Select("SELECT * FROM user WHERE userId = #{userId}")
	public User selectUserById(Integer userId);
	
	@Select("SELECT * FROM user WHERE userPhone = #{userPhone}")
	public User selectUserByPhone(Long phone);
	
	@Insert("insert into user(userPwd,userName,userPhone,createAt,updateAt) "
			+ "values(#{userPwd},#{userName},#{userPhone},#{createAt},#{updateAt})")
	@Options(useGeneratedKeys=true, keyProperty="userId")
	public void insertUser(User user);
}
