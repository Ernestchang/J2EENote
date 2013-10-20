package com.bingoogol.algorithm.service;

import java.util.List;

import com.bingoogol.algorithm.model.User;

public interface IUserService {
	/**
	 * 添加用户
	 * @param user 用户实体
	 */
	public void addUser(User user);
	/**
	 * 修改用户
	 * @param user 用户实体
	 */
	public void updateUser(User user);
	/**
	 * 根据id获取用户实体
	 * @param uid 用户id
	 * @return 用户实体
	 */
	public User getUser(Integer uid);
	/**
	 * 根据用户id删除用户
	 * @param uid 用户id
	 */
	public void deleteUser(Integer uid);
	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return 用户实体
	 */
	public User getByUsername(String username);
	/**
	 * 获取所有用户
	 * @return 用户集合
	 */
	public List<User> listAllUser();
}
