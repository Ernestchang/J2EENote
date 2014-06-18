package com.wh.converter;

import java.util.Map;
import java.util.StringTokenizer;

import org.apache.struts2.util.StrutsTypeConverter;

import com.wh.bean.User;

public class UserConverter2 extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		User user = new User();
		String value = values[0];
		StringTokenizer st = new StringTokenizer(value,";");
		user.setUsername(st.nextToken());
		user.setPassword(st.nextToken());
		return user;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		User user = (User) o;
		String username = user.getUsername();
		String password = user.getPassword();
		String userInfo = "username: " + username + ",password: " + password + "==继承自StrutsTypeConverter";
		return userInfo;
	}

}
