package com.wh.base.service.privilege;

import java.util.List;

import com.wh.base.bean.privilege.SystemPrivilege;
import com.wh.base.service.base.DAO;

public interface SystemPrivilegeService extends DAO<SystemPrivilege> {
	/**
	 * 批量保存系统权限
	 * @param privileges
	 */
	public void batchSave(List<SystemPrivilege> privileges);
}
