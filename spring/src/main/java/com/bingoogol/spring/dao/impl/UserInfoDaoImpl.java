package com.bingoogol.spring.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bingoogol.spring.dao.UserInfoDao;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public int plusPrice(String sellerid, int price) {
		return jdbcTemplate.update("update userinfo set gold=gold+? where id=?", price, sellerid);
	}

	@Override
	public int minusPrice(String buyerid, int price) {
		return jdbcTemplate.update("update userinfo set gold=gold-? where id=?", price, buyerid);
	}

}
