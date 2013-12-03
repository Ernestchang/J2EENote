package com.bingoogol.spring.dao;

import java.sql.Timestamp;
import java.util.Map;

import com.bingoogol.spring.dto.Pager;
import com.bingoogol.spring.dto.PagerJson;
import com.bingoogol.spring.dto.UserLoginDto;
import com.bingoogol.spring.dto.UserRegistDto;

public interface UserDao {
	public Long getCountByUsername(String username);
	public Long getCountByEmail(String email);
	public int register(UserRegistDto userRegistDto);
	public Map<String, Object> findUserInfoById(String id);
	public int active(String id);
	public Map<String, Object> login(UserLoginDto userLoginDto);
	public int addUserInfo(String id, String activecode, Timestamp expiretime, int cid);
	
	public PagerJson  fenye(Pager pager);
	public Map<String, Object> resendemail(String id);
	public int updateActiveUserInfo(String id, String activecode, Timestamp expiretime);
	
}
