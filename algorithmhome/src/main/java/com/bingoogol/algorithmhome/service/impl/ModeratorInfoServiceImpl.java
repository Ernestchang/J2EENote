package com.bingoogol.algorithmhome.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingoogol.algorithmhome.dao.ModeratorInfoDao;
import com.bingoogol.algorithmhome.dao.UserDao;
import com.bingoogol.algorithmhome.service.ModeratorInfoService;

@Service
@Transactional
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
