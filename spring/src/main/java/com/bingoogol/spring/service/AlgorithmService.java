package com.bingoogol.spring.service;

import java.util.List;
import java.util.Map;

import com.bingoogol.spring.dto.AddAlgorithmDto;
import com.bingoogol.spring.dto.Pager;
import com.bingoogol.spring.dto.PagerJson;



public interface AlgorithmService {
	public boolean addAlgorithm(AddAlgorithmDto addAlgorithmDto);

	public Map<String, Object> getAlgorithmById(String id);

	/**
	 * 根据版主id查看该版主所管理板块下未审核的算法列表
	 * @param uid
	 * @return
	 */
	public List<Map<String,Object>> notvertifylist(String uid);

	/**
	 * 修改算法的状态
	 * @param id 算法id
	 * @param mender 操作者id
	 * @param status 1表示已删除，2表示未通过审核，3表示输入输出已审核,4表示待审核
	 * @return
	 */
	public boolean changeStatus(String id, String mender, int status);
	/**
	 * 查询二级学科下下载次数前15的算法
	 * @param cid
	 * @return
	 */
	public List<Map<String,Object>> listchannel2(int cid);
	
	/**
	 * 分页获取三级学科下面的算法
	 * @param pager
	 * @param cid
	 * @return
	 */
	public PagerJson listchannel3(Pager pager, int cid);
	
	/**
	 * 分页查找算法
	 * @param pager
	 * @param key
	 * @return
	 */
	public PagerJson find(Pager pager, String key);
}
