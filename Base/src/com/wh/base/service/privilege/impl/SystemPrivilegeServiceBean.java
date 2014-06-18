package com.wh.base.service.privilege.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.base.bean.privilege.SystemPrivilege;
import com.wh.base.service.base.DaoSupport;
import com.wh.base.service.privilege.SystemPrivilegeService;
@Service @Transactional
public class SystemPrivilegeServiceBean extends DaoSupport<SystemPrivilege> implements SystemPrivilegeService {

	@Override
	public void batchSave(List<SystemPrivilege> privileges) {
		for(SystemPrivilege p : privileges){
			save(p);
		}
	}

}
