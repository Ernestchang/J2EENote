package com.wh.base.service.user;

import com.wh.base.bean.privilege.User;
import com.wh.base.service.base.DAO;

public interface UserService extends DAO<User> {
	/**
	 * 判断用户是否存在
	 * @param username
	 * @return
	 */
	public boolean exsit(String username);
	/**
	 * 判断用户名及密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkUser(String username, String password);
}
