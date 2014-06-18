package com.wh.base.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.wh.base.bean.privilege.PrivilegeGroup;
import com.wh.base.bean.privilege.SystemPrivilege;
import com.wh.base.bean.privilege.SystemPrivilegePK;
import com.wh.base.bean.privilege.User;
import com.wh.base.utils.WebUtil;

public class PermissionTag extends TagSupport {
	private static final long serialVersionUID = 2274050576698204851L;
	private String module;
	private String privilege;
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	@Override
	public int doStartTag() throws JspException {
		User user = WebUtil.getUser();
		SystemPrivilege privilege = new SystemPrivilege(new SystemPrivilegePK(this.module, this.privilege));
		for(PrivilegeGroup group : user.getGroups()){
			if(group.getPrivileges().contains(privilege)){
				return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;
	}
}
