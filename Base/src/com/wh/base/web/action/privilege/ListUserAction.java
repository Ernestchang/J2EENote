package com.wh.base.web.action.privilege;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.bean.QueryResult;
import com.wh.base.bean.privilege.User;
import com.wh.base.service.user.UserService;
@Controller
public class ListUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	@Override
	public String execute() throws Exception {
		QueryResult<User> queryResult = userService.getScrollData();
		ArrayList<User> userlist = (ArrayList<User>) queryResult.getResultlist();
		ActionContext.getContext().put("userlist", userlist);
		return SUCCESS;
	}
}
