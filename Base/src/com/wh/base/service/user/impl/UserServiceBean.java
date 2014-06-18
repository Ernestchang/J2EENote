package com.wh.base.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wh.base.bean.privilege.User;
import com.wh.base.service.base.DaoSupport;
import com.wh.base.service.user.UserService;
import com.wh.base.utils.MD5;
@Service @Transactional  //spring只会对定义在本类的方法应用事务通知(Advice)
public class UserServiceBean extends DaoSupport<User> implements UserService {
	@Override
	public void save(User user) {
		user.setPassword(MD5.MD5Encode(user.getPassword()));
		super.save(user);
	}
	@Override
	public void update(User user) {
		user.setPassword(MD5.MD5Encode(user.getPassword()));
		super.update(user);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public boolean exsit(String username){
		return getCount("o.username = ?1", new Object[]{username}) > 0;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public boolean checkUser(String username, String password){
		return getCount("o.username = ?1 and o.password = ?2", new Object[]{username, MD5.MD5Encode(password)}) > 0;
	}
}
