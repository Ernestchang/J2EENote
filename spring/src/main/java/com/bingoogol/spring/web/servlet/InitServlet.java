package com.bingoogol.spring.web.servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bingoogol.spring.service.ChannelService;

/**
 * 系统初始化
 * 
 * @author bingoogol@sina.com
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1147739850296857965L;
	private static WebApplicationContext wc;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 初始化spring的工厂
		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		initLeftMenu();
	}

	private void initLeftMenu() {
		ChannelService channelService = (ChannelService) wc.getBean("channelServiceImpl");
		List<Map<String, Object>> channel1s = channelService.listChilds(-1);
		for (Map<String, Object> channel1 : channel1s) {
			channel1.put("childs", channelService.listChilds((int) channel1.get("id")));
		}
		wc.getServletContext().setAttribute("leftChannel1s", channel1s);
	}

	public static WebApplicationContext getWc() {
		return wc;
	}
}
