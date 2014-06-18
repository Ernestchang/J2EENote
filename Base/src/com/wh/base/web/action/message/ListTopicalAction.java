package com.wh.base.web.action.message;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.bean.QueryResult;
import com.wh.base.bean.Topical;
import com.wh.base.service.message.TopicalService;

@Controller
public class ListTopicalAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private TopicalService topicalService;
	@Override
	public String execute() throws Exception {
		QueryResult<Topical> queryResult = topicalService.getScrollData();
		ArrayList<Topical> topicallist = (ArrayList<Topical>) queryResult.getResultlist();
		ActionContext.getContext().put("topicallist", topicallist);
		return SUCCESS;
	}
}
