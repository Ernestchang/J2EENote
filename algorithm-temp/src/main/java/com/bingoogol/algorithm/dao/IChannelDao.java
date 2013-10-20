package com.bingoogol.algorithm.dao;

import java.util.List;

import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.model.Channel;


public interface IChannelDao {
	/**
	 * 添加栏目
	 * @param channel 栏目实体
	 */
	public void addChannel(Channel channel);
	/**
	 * 获取顶级栏目
	 * @return 顶级栏目集合
	 */
	public List<Channel> listTopChannel(Pager pager);
	/**
	 * 根据父栏目编号获取子栏目集合
	 * @param pid 栏目编号
	 * @return 栏目集合
	 */
	public List<Channel> listChannel(Pager pager, Integer pid);
	/**
	 * 获取所有栏目集合
	 * @return 栏目集合
	 */
	public List<Channel> listAllChannel(Pager pager);
	
	public Channel getChannel(Integer id);
}
