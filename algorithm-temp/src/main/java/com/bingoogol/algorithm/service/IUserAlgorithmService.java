package com.bingoogol.algorithm.service;

import com.bingoogol.algorithm.model.Algorithm;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.model.UserAlgorithm;

public interface IUserAlgorithmService {
	
	public void add(User user,Algorithm algorithm);
	public UserAlgorithm get(Integer uid,Integer aid);
}
