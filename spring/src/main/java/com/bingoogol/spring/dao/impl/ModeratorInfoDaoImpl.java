package com.bingoogol.spring.dao.impl;

import java.util.List;
import java.util.Map;

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
		return jdbcTemplate.update("insert into moderatorinfo(id,title,degree,summary,approve,realname,cid) values(?,?,?,?,?,?,?)", applyDto.getUid(), applyDto.getTitle(), applyDto.getDegree(), applyDto.getSummary(), applyDto.getApprove(), applyDto.getRealname(), applyDto.getCid());
	}

	@Override
	public List<Map<String, Object>> notvertifylist() {
		return jdbcTemplate.queryForList("select u.username,u.id uid,c.id cid,c.name cname from user u inner join moderatorinfo mi on u.id = mi.id inner join channel c on c.id=mi.cid where mi.status=1");
	}

	@Override
	public int changeStatus(String id, int status) {
		return jdbcTemplate.update("update moderatorinfo set status=? where id=?", status, id);
	}

}
