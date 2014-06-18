package com.wh.base.service.privilege.impl;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wh.base.bean.QueryResult;
import com.wh.base.bean.privilege.User;
import com.wh.base.service.user.UserService;

public class UserServiceBeanTest {
	private static ApplicationContext cxt;
	private static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			cxt = new ClassPathXmlApplicationContext("beans.xml");
			userService = (UserService)cxt.getBean("userServiceBean");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void init() {
		
	}
	@Test
	public void testClear() {
		
	}

	@Test
	public void testSave() {
//		for(int i = 0; i < 5; i++) {
//			User user = new User("1007092136", "呵呵", "bingo" + i);
//			userService.save(user);
//		}
	}

	@Test
	public void testUpdate() {
		User user = userService.find(2);
		user.setRealname("呵呵");
		userService.update(user);
	}

	@Test
	public void testDelete() {
		userService.delete(2,3);
	}

	@Test
	public void testFind() {
		User user = userService.find(2);
		System.out.println(user.getRealname());
	}

	@Test
	public void testGetCount() {
		System.out.println(userService.getCount());
		String where = "o.username = ?1 and realname = ?2";
		Object[] queryParams = {"1007092136","呵呵"};
		System.out.println(userService.getCount(where, queryParams));
	}

	@Test
	public void testGetScrollData() {
		QueryResult<User> queryResult = userService.getScrollData(0,3);
		ArrayList<User> list = (ArrayList<User>) queryResult.getResultlist();
		for(User user : list) {
			System.out.println(user.getPassword());
		}
	}

}
