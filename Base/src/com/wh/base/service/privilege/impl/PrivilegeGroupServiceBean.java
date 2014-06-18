package com.wh.base.service.privilege.impl;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.base.bean.privilege.PrivilegeGroup;
import com.wh.base.bean.privilege.User;
import com.wh.base.service.base.DaoSupport;
import com.wh.base.service.privilege.PrivilegeGroupService;
@Service @Transactional
public class PrivilegeGroupServiceBean extends DaoSupport<PrivilegeGroup> implements PrivilegeGroupService {
	@Override
	public void delete(Serializable... entityids) {
		for(Serializable id : entityids){
			PrivilegeGroup group = find(id);
			for(User user : group.getUsers()){
				user.getGroups().remove(group);
			}
			em.remove(group);
		}
	}

	@Override
	public void save(PrivilegeGroup entity) {
		entity.setGroupid(UUID.randomUUID().toString());
		super.save(entity);
	}
}
