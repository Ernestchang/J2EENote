package com.bingoogol.algorithm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bingoogol.algorithm.dao.IChannelDao;
import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.model.Channel;

@Repository("channelDao")
public class ChannelDao extends GenericDao<Channel> implements IChannelDao {

	public void addChannel(Channel channel) {
		super.add(channel);
	}

	@Override
	public List<Channel> listTopChannel(Pager pager) {
		String hql = "from Channel c where c.isTop=?";
		return super.list(pager, hql, true);
	}

	@Override
	public List<Channel> listChannel(Pager pager, Integer pid) {
		String hql = "select c from Channel c left join fetch c.parent cp where c.status=? and cp.id=?";
		return super.list(pager, hql, new Object[]{1,pid});
	}

	@Override
	public List<Channel> listAllChannel(Pager pager) {
		String hql = "from Channel";
		return super.list(pager,hql);
	}
	
	public Channel getChannel(Integer id) {
		return super.load(id);
	}
}
