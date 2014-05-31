package com.bingoogol.algorithmhome.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bingoogol.algorithmhome.dao.AlgorithmUserDao;

@Repository
public class AlgorithmUserDaoImpl implements AlgorithmUserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(String uid, String aid) {
		return jdbcTemplate.update("insert into algorithmuser(uid,aid) values(?,?)", uid, aid);
	}
}
