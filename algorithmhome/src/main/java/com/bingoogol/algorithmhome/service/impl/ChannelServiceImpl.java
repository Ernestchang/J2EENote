package com.bingoogol.algorithmhome.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingoogol.algorithmhome.dao.ChannelDao;
import com.bingoogol.algorithmhome.service.ChannelService;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelDao channelDao;

	@Override
	public List<Map<String, Object>> listChilds(int cid) {
		return channelDao.listChilds(cid);
	}

	@Override
	public boolean addChannel(String name, int cid, int level, String mender) {
		return channelDao.addChannel(name, cid, level, mender) == 1 ? true : false;
	}

	@Override
	public boolean isNameAvailable(String name) {
		return channelDao.getCountByName(name) == 0 ? true : false;
	}

	@Override
	public List<Map<String, Object>> selectChannel(int cid) {
		return channelDao.selectChannel(cid);
	}
}
