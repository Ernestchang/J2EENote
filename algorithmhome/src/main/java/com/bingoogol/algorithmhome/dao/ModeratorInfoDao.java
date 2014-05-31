package com.bingoogol.algorithmhome.dao;

import java.util.List;
import java.util.Map;

import com.bingoogol.algorithmhome.dto.ApplyDto;

public interface ModeratorInfoDao {

	public int add(ApplyDto applyDto);
	/**
	 * 查看未审核的版主
	 * @return
	 */
	public List<Map<String,Object>> notvertifylist();
	/**
	 * 
	 * @param id 版主id
	 * @param mender 操作者
	 * @param status 1表示待审核，2表示通过审核，3表示未通过审核
	 * @return
	 */
	public int changeStatus(String id, int status);

}
