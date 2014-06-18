package com.bingoogol.spring.dao;

import java.util.List;
import java.util.Map;

public interface ChannelDao {
	/**
	 * 查询子学科列表
	 * 
	 * @param cid
	 *            父学科ID，一级学科的cid为-1
	 * @return
	 */
	public List<Map<String, Object>> listChilds(int cid);

	/**
	 * 添加学科
	 * 
	 * @param name
	 *            学科名字
	 * @param cid
	 *            父学科ID，一级学科的cid为-1
	 * @param level
	 *            学科等级
	 * @param mender
	 *            操作者ID
	 * @return
	 */
	public int addChannel(String name, int cid, int level, String mender);

	/**
	 * 根据学科名字查询学科总数
	 * 
	 * @param name
	 * @return
	 */
	public Long getCountByName(String name);

	/**
	 * 根据父学科ID查询栏目，只返回id和name
	 * 
	 * @param cid
	 * @return
	 */
	public List<Map<String, Object>> selectChannel(int cid);
}
