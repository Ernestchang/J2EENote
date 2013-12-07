package com.bingoogol.spring.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bingoogol.spring.dao.UserDao;
import com.bingoogol.spring.dto.UserLoginDto;
import com.bingoogol.spring.dto.UserRegistDto;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long getCountByUsername(String username) {
		return jdbcTemplate.queryForObject("select count(*) from user u where u.username=?", Long.class, username);
	}

	@Override
	public Long getCountByEmail(String email) {
		return jdbcTemplate.queryForObject("select count(*) from user u where u.email=?", Long.class, email);
	}

	@Override
	public int register(UserRegistDto userRegistDto) {
		return jdbcTemplate.update("insert into user(id,username,password,email,createtime,updatetime) values(?,?,?,?,?,?)", userRegistDto.getId(), userRegistDto.getUsername(), userRegistDto.getPassword(), userRegistDto.getEmail(), new Date(), new Date());
	}

	@Override
	public int changeStatus(String id, int status) {
		return jdbcTemplate.update("update user set status=? where id=?", status, id);
	}

	@Override
	public Map<String, Object> login(UserLoginDto userLoginDto) {
		return jdbcTemplate.queryForMap("select id,username,type,status from user where status!=1 and username=? and password=?", userLoginDto.getUsername(), userLoginDto.getPassword());
	}

	@Override
	public Map<String, Object> findUserInfoById(String id) {
		return jdbcTemplate.queryForMap("select activecode,expiretime from userinfo where id=?", id);
	}

	@Override
	public int addUserInfo(String id, String activecode, Timestamp expiretime, int cid) {
		return jdbcTemplate.update("insert into userinfo(id,activecode,expiretime,cid) values(?,?,?,?)", id, activecode, expiretime, cid);
	}

	@Override
	public Map<String, Object> resendemail(String id) {
		return jdbcTemplate.queryForMap("select email,username from user u where status=3 and id=?", id);
	}

	@Override
	public int updateActiveUserInfo(String id, String activecode, Timestamp expiretime) {
		return jdbcTemplate.update("update userinfo set activecode=?,expiretime=? where id=?", activecode, expiretime, id);
	}

	@Override
	public int getGold(String id) {
		return jdbcTemplate.queryForObject("select gold from userinfo where id=?", Integer.class, id);
	}

	@Override
	public int setUpdateInfo(String mender) {
		return jdbcTemplate.update("update user set mender=?,updatetime=? where id=?", mender, new Date(), mender);
	}

	@Override
	public int changeToModerator(String id, String mender) {
		return jdbcTemplate.update("update user set type=2,mender=?,updatetime=? where id=?", mender, new Date(), id);
	}
}
