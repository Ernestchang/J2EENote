package com.wh.base.web.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.wh.base.bean.privilege.PrivilegeGroup;
import com.wh.base.bean.privilege.SystemPrivilege;
import com.wh.base.bean.privilege.User;
import com.wh.base.service.privilege.PrivilegeGroupService;
import com.wh.base.service.privilege.SystemPrivilegeService;
import com.wh.base.service.user.UserService;

public class PrivilegeInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	@Resource
	private SystemPrivilegeService privilegeService;
	@Resource
	private PrivilegeGroupService groupService;
	
	@Override
	public void destroy() {
	}

	@Override
	public void init() {
		initSystemPrivilege();
		initPrivilegeGroup();
		initAdmin();
	}
	/**
	 * 初始化管理员账号
	 */
	private void initAdmin() {
		if(userService.getCount() == 0) {
			User user = new User();
			user.setUsername("admin");
			user.setPassword("123456");
			user.setRealname("系统管理员");
			//赋予权限
			user.getGroups().addAll(groupService.getScrollData().getResultlist());
			userService.save(user);
		}
	}
	/**
	 * 初始化权限
	 */
	private void initSystemPrivilege() {
		if(privilegeService.getCount()==0){
			List<SystemPrivilege> privileges = new ArrayList<SystemPrivilege>();
			
			privileges.add(new SystemPrivilege("user","insert","用户添加"));
			privileges.add(new SystemPrivilege("user","update","用户修改"));
			privileges.add(new SystemPrivilege("user","view","用户查看"));
			privileges.add(new SystemPrivilege("user","privilegeGroupSet","用户权限组设置"));
			
			privileges.add(new SystemPrivilege("topical","insert","说说添加"));
			privileges.add(new SystemPrivilege("topical","view","说说查看"));
			
			privilegeService.batchSave(privileges);
		}		
	}
	/**
	 * 初始化系统权限组
	 */
	private void initPrivilegeGroup() {
		if(groupService.getCount()==0){
			PrivilegeGroup group = new PrivilegeGroup();
			group.setName("系统权限组");
			group.getPrivileges().addAll(privilegeService.getScrollData().getResultlist());
			groupService.save(group);
		}		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		return invocation.invoke();
	}

}
