package com.bingoogol.spring.service;

import java.util.List;
import java.util.Map;

import com.bingoogol.spring.dto.AddAlgorithmDto;



public interface AlgorithmService {
	public boolean addAlgorithm(AddAlgorithmDto addAlgorithmDto);

	public Map<String, Object> getAlgorithmById(String id);

	public List<Map<String,Object>> list();

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
}
