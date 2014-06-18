package com.bingoogol.spring.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bingoogol.spring.dao.ChannelDao;

@Repository
public class ChannelDaoImpl implements ChannelDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> listChilds(int cid) {
		if (cid == -1) {
			return jdbcTemplate.queryForList("select c.id,c.name,u.username mender from channel c inner join user u on c.mender=u.id where c.status=2 and c.level=1");
		}
		return jdbcTemplate.queryForList("select c.id,c.name,p.name parent,u.username mender from channel c inner join channel p on p.id=c.cid inner join user u on c.mender=u.id where c.status=2 and c.cid=?", cid);
	}

	@Override
	public int addChannel(String name, int cid, int level, String mender) {
		if (cid == -1) {
			return jdbcTemplate.update("insert into channel(name,mender,status,level) values(?,?,?,?)", name, mender, 2, level);
		}
		return jdbcTemplate.update("insert into channel(name,mender,status,level,cid) values(?,?,?,?,?)", name, mender, 2, level, cid);
	}

	@Override
	public Long getCountByName(String name) {
		return jdbcTemplate.queryForObject("select count(*) from channel c where c.status!=1 and c.name=?", Long.class, name);
	}

	@Override
	public List<Map<String, Object>> selectChannel(int cid) {
		if (cid == -1) {
			return jdbcTemplate.queryForList("select c.id,c.name from channel c where c.status=2 and c.level=1");
		}
		return jdbcTemplate.queryForList("select c.id,c.name from channel c where c.status=2 and c.cid=?", cid);
	}
}
