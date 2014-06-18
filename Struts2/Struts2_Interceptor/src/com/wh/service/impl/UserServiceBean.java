package com.wh.service.impl;

import com.wh.bean.User;
import com.wh.service.UserService;

public class UserServiceBean implements UserService {

	@Override
	public boolean validate(User user) {
		if("wanghao".equals(user.getUsername()) && "bingo".equals(user.getPassword())) {
			return true;
		}
		return false;
	}

}
