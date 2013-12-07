package com.bingoogol.spring.service;

import java.util.Map;

import com.bingoogol.spring.dto.ApplyDto;
import com.bingoogol.spring.dto.UserLoginDto;
import com.bingoogol.spring.dto.UserRegistDto;

public interface UserService {
	public String register(UserRegistDto userRegistDto);

	public boolean isUsernameAvailable(String username);

	public boolean isEmailAvailable(String email);

	public boolean active(String id, String activecode);

	public Map<String, Object> login(UserLoginDto userLoginDto);

	public boolean resendemail(String id);

	public int getGold(String id);

	public boolean buy(String aid, String buyerid, String sellerid, int price);

	public boolean apply(ApplyDto applyDto);
}
