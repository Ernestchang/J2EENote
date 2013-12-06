package com.bingoogol.spring.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bingoogol.spring.dao.ModeratorInfoDao;
import com.bingoogol.spring.dto.ApplyDto;

@Repository
public class ModeratorInfoDaoImpl implements ModeratorInfoDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(ApplyDto applyDto) {
		return jdbcTemplate.update("insert into moderatorinfo(id,title,degree,summary,approve,realname) values(?,?,?,?,?,?)", applyDto.getUid(),applyDto.getTitle(),applyDto.getDegree(),applyDto.getSummary(),applyDto.getApprove(),applyDto.getRealname());
	}

}
