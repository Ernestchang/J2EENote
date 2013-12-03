package com.bingoogol.algorithm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingoogol.algorithm.dao.IChannelDao;
import com.bingoogol.algorithm.model.Channel;
import com.bingoogol.algorithm.service.IChannelService;

@Service("channelService")
public class ChannelService implements IChannelService {
	@Autowired
	private IChannelDao channelDao;

	public void addChannel(Channel channel) {
		channelDao.addChannel(channel);
	}

	@Override
	public List<Channel> listTopChannel() {
		return channelDao.listTopChannel(null);
	}

	@Override
	public List<Channel> listChannel(Integer pid) {
		return channelDao.listChannel(null,pid);
	}

	@Override
	public List<Channel> listAllChannel() {
		return channelDao.listAllChannel(null);
	}

	@Override
	public Channel getChannel(Integer id) {
		return channelDao.getChannel(id);
	}

}
