package com.wh.base.service.message.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wh.base.bean.Topical;
import com.wh.base.service.message.TopicalService;
import com.wh.base.service.user.UserService;

public class TopicalServiceBeanTest {

	private static ApplicationContext cxt;
	private static TopicalService topicalService;
	private static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			cxt = new ClassPathXmlApplicationContext("beans.xml");
			topicalService = (TopicalService)cxt.getBean("topicalServiceBean");
			userService = (UserService)cxt.getBean("userServiceBean");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		Topical topical = new Topical();
		topical.setContent("呵呵");
		topical.setUser(userService.find("1007092136"));
		topicalService.save(topical);
	}

}
