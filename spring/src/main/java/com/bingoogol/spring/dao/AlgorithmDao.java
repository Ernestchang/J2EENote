package com.bingoogol.spring.dao;

import java.util.List;
import java.util.Map;

import com.bingoogol.spring.dto.AddAlgorithmDto;

public interface AlgorithmDao {
	public int addAlgorithm(AddAlgorithmDto addAlgorithmDto);

	public Map<String, Object> getAlgorithmById(String id);

	
	
	
	
	
	
	public List<Map<String, Object>> list();
}
