package com.bingoogol.algorithm.dao.impl;

import org.springframework.stereotype.Repository;

import com.bingoogol.algorithm.dao.IUserAlgorithmDao;
import com.bingoogol.algorithm.model.UserAlgorithm;

@Repository("userAlgorithmDao")
public class UserAlgorithmDao extends GenericDao<UserAlgorithm> implements IUserAlgorithmDao {

	@Override
	public UserAlgorithm get(Integer uid, Integer aid) {
		String hql = "from UserAlgorithm ua left join fetch ua.user u left join fetch ua.algorithm a where a.id=? and u.id=?";
		return (UserAlgorithm) super.queryObject(hql, new Object[] { aid, uid });
	}

}
