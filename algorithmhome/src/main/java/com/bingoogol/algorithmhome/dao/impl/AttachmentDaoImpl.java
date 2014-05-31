package com.bingoogol.algorithmhome.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bingoogol.algorithmhome.dao.AttachmentDao;

@Repository
public class AttachmentDaoImpl implements AttachmentDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addAttachment(String id, String name, String hash) {
		return jdbcTemplate.update("insert into attachment(id,name,hash) values(?,?,?)", id, name, hash);
	}

	@Override
	public Map<String, Object> getAttachmentById(String id) {
		return jdbcTemplate.queryForMap("select * from attachment where status=2 and id=?", id);
	}

	@Override
	public String getHashById(String id) {
		return jdbcTemplate.queryForObject("select hash from attachment where status=2 and id=?", String.class, id);
	}
}
