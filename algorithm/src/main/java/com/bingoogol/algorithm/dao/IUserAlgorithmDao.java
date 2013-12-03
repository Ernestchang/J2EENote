package com.bingoogol.algorithm.dao;

import com.bingoogol.algorithm.model.UserAlgorithm;

public interface IUserAlgorithmDao {
	
	public void add(UserAlgorithm e);
	public UserAlgorithm get(Integer uid,Integer aid);
	
}
