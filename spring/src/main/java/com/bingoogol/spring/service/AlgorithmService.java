package com.bingoogol.spring.service;

import java.util.List;
import java.util.Map;

import com.bingoogol.spring.dto.AddAlgorithmDto;



public interface AlgorithmService {
	public boolean addAlgorithm(AddAlgorithmDto addAlgorithmDto);

	public Map<String, Object> getAlgorithmById(String id);

	
	
	
	
	public List<Map<String,Object>> list();
}
