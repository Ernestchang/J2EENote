package com.bingoogol.algorithm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingoogol.algorithm.dao.IUserDao;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.service.IUserService;
import com.bingoogol.algorithm.util.MD5Util;

@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;

	public void addUser(User user) {
		user.setPassword(MD5Util.md5(user.getUsername(), user.getPassword()));
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public User getUser(Integer uid) {
		return userDao.getUser(uid);
	}

	public void deleteUser(Integer uid) {
		userDao.deleteUser(uid);
	}

	@Override
	public List<User> listAllUser() {
		return userDao.listAllUser(null);
	}

	@Override
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

}
