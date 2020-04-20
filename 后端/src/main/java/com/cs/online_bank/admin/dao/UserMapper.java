package com.cs.online_bank.admin.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import com.cs.online_bank.admin.model.User;
@Mapper
public interface UserMapper {
	//根据用户名查找用户信息
	User findByName(String userName);
	//查找所有的用户
	List<User> findAll();
	//添加用户
	void save(User user);
	//修改用户信息
	void update(User user);
	//查找权限
	public Set<String> getPermission(String userName);
	
	public User findById(Integer id);
}
