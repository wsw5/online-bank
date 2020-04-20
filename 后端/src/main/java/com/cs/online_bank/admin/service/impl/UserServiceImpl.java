package com.cs.online_bank.admin.service.impl;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cs.online_bank.admin.dao.UserMapper;
import com.cs.online_bank.admin.model.User;
import com.cs.online_bank.admin.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.findByName(userName);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.update(user);
	}

	@Override
	public Set<String> getPermission(String userName) {
		return userMapper.getPermission(userName);
	}

	@Override
	public User findById(Integer id) {
		return userMapper.findById(id);
	}

	

	

}
