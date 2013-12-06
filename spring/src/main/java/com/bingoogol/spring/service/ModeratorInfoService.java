package com.bingoogol.spring.service;

import java.util.List;
import java.util.Map;

public interface ModeratorInfoService {
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
	public boolean changeStatus(String id, String mender, int status);
}
