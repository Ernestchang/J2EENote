package com.wh.base.web.action.message;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.bean.Topical;
import com.wh.base.bean.privilege.Permission;
import com.wh.base.bean.privilege.User;
import com.wh.base.service.message.TopicalService;
import com.wh.base.utils.SiteUrl;
import com.wh.base.utils.WebUtil;
@Controller
public class AddTopicalAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String content;
	@Resource
	private TopicalService topicalService;
	@Override @Permission(module="topical", privilege="insert")
	public String execute() throws Exception {
		User user = WebUtil.getUser();
		Topical topical = new Topical(content, user);
		topicalService.save(topical);
		ActionContext.getContext().put("message", "发表成功");
		ActionContext.getContext().put("urladdress", SiteUrl.readUrl("message.list"));
		return "message";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
