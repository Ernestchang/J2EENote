package com.bingoogol.algorithmhome.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bingoogol.algorithmhome.exception.PrivilegeException;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String,Object> loginUser = (Map<String, Object>)session.getAttribute("loginUser");
		if(loginUser==null) {
			response.sendRedirect(request.getContextPath()+"/login/login");
			return false;
		} else {
			int type = (int) loginUser.get("type");
			if(type != 1) {
				throw new PrivilegeException("您没有权限访问该功能");
			}
		}
		return super.preHandle(request, response, handler);
	}
}