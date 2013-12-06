package com.bingoogol.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bingoogol.spring.dao.ModeratorInfoDao;
import com.bingoogol.spring.dao.UserDao;
import com.bingoogol.spring.service.ModeratorInfoService;

@Service
public class ModeratorInfoServiceImpl implements ModeratorInfoService {
	@Resource
	private ModeratorInfoDao moderatorInfoDao;
	@Resource
	private UserDao userDao; 

	@Override
	public List<Map<String, Object>> notvertifylist() {
		return moderatorInfoDao.notvertifylist();
	}

	@Override
	public boolean changeStatus(String id, String mender, int status) {
		if (moderatorInfoDao.changeStatus(id, status) + userDao.changeToModerator(id,mender) == 2) {
			return true;
		}
		return false;
	}

}
