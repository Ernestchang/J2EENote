package com.bingoogol.algorithm.dao;

import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.dto.PagerJson;
import com.bingoogol.algorithm.model.Algorithm;

public interface IAlgorithmDao {
	public void addAlgorithm(Algorithm algorithm);
	public PagerJson<Algorithm> find(Pager pager, Integer cid,String con);
	
	public Algorithm getAlgorithm(Integer id);
}
