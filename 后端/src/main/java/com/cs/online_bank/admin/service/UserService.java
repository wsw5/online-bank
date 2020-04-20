package com.cs.online_bank.admin.service;
import java.util.List;
import java.util.Set;

import com.cs.online_bank.admin.model.User;
public interface UserService{
	public User findById(Integer id);
	User findByName(String userName);
	List<User> findAll();
	void save(User user);
	void updateUser(User user);
	public Set<String> getPermission(String userName);
}
