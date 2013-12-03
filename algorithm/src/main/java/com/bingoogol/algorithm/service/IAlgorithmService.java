package com.bingoogol.algorithm.service;

import java.io.InputStream;

import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.dto.PagerJson;
import com.bingoogol.algorithm.model.Algorithm;

public interface IAlgorithmService {
	
	public void addAlgorithm(String realPath, Algorithm algorithm2, InputStream thesis,InputStream algorithm);
	
	public PagerJson<Algorithm> find(Pager pager, Integer cid,String con);
	
	public Algorithm getAlgorithm(Integer id);
}
