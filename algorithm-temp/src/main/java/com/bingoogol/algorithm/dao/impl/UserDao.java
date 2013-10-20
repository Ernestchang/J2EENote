package com.bingoogol.algorithm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bingoogol.algorithm.dao.IUserDao;
import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.model.User;

@Repository("userDao")
public class UserDao extends GenericDao<User> implements IUserDao {

	public void addUser(User user) {
		super.add(user);
	}

	public void updateUser(User user) {
		super.update(user);
	}

	public User getUser(Integer uid) {
		return super.load(uid);
	}

	public void deleteUser(Integer uid) {
		super.delete(uid);
	}

	@Override
	public List<User> listAllUser(Pager pager) {
		String hql = "from User";
		return super.list(pager, hql);
	}

	@Override
	public User getByUsername(String username) {
		String hql = "from User u where u.username=?";
		return (User) super.queryObject(hql, username);
	}

}
