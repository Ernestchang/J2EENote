package com.bingoogol.algorithm.web.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bingoogol.algorithm.model.Channel;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.service.IChannelService;
import com.bingoogol.algorithm.service.IUserService;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 8250630912608471407L;
	private static WebApplicationContext wc;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 初始化spring的工厂
		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		initChannel();
		initUser();
	}
	
	private void initUser() {
		IUserService userService = (IUserService) wc.getBean("userService");
		if (userService.listAllUser().size() < 1) {
			User user = new User();
			user.setUsername("user1");
			user.setPassword("123456");
			user.setEmail("1111111@qq.com");
			user.setDateCreated(new Date());
			user.setDateModified(new Date());
			user.setScore(0);
			userService.addUser(user);
			User user2 = new User();
			user2.setUsername("user2");
			user2.setPassword("123456");
			user2.setEmail("2222222@qq.com");
			user2.setDateCreated(new Date());
			user2.setDateModified(new Date());
			user2.setScore(0);
			userService.addUser(user2);
			System.out.println("------------------------初始化用户-----------------------------");
		}
	}
	private void initChannel() {
		IChannelService channelService = (IChannelService) wc.getBean("channelService");
		List<Channel> topChannels = channelService.listTopChannel();
		for(Channel channel : topChannels) {
			channel.setChildrens(channelService.listChannel(channel.getId()));
		}
		wc.getServletContext().setAttribute("topChannels", topChannels);
	}

	public static WebApplicationContext getWc() {
		return wc;
	}

}
