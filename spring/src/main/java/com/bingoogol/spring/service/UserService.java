package com.bingoogol.spring.service;

import java.util.Map;

import com.bingoogol.spring.dto.Pager;
import com.bingoogol.spring.dto.PagerJson;
import com.bingoogol.spring.dto.UserLoginDto;
import com.bingoogol.spring.dto.UserRegistDto;

public interface UserService {
	public String register(UserRegistDto userRegistDto);

	public boolean isUsernameAvailable(String username);

	public boolean isEmailAvailable(String email);

	public boolean active(String id, String activecode);
	
	public PagerJson fenye(Pager pager);

	public Map<String, Object> login(UserLoginDto userLoginDto);

	public boolean resendemail(String id);
	
	public int getGold(String id);

	public boolean buy(String buyerid, String sellerid, int price);
}
