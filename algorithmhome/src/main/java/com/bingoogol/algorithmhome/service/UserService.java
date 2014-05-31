package com.bingoogol.algorithmhome.service;

import java.util.Map;

import com.bingoogol.algorithmhome.dto.ApplyDto;
import com.bingoogol.algorithmhome.dto.UserLoginDto;
import com.bingoogol.algorithmhome.dto.UserRegistDto;

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
