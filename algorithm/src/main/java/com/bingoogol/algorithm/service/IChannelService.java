package com.bingoogol.algorithm.service;

import java.util.List;

import com.bingoogol.algorithm.model.Channel;


public interface IChannelService {
	/**
	 * 添加栏目
	 * @param channel 栏目实体
	 */
	public void addChannel(Channel channel);
	/**
	 * 获取顶级栏目
	 * @return 顶级栏目集合
	 */
	public List<Channel> listTopChannel();
	/**
	 * 根据父栏目编号获取子栏目集合
	 * @param pid 栏目编号
	 * @return 栏目集合
	 */
	public List<Channel> listChannel(Integer pid);
	/**
	 * 获取所有栏目集合
	 * @return 栏目集合
	 */
	public List<Channel> listAllChannel();
	
	public Channel getChannel(Integer id);
}
