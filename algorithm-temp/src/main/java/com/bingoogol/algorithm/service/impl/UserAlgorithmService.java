package com.bingoogol.algorithm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingoogol.algorithm.dao.IUserAlgorithmDao;
import com.bingoogol.algorithm.dao.IUserDao;
import com.bingoogol.algorithm.model.Algorithm;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.model.UserAlgorithm;
import com.bingoogol.algorithm.service.IUserAlgorithmService;

@Service
public class UserAlgorithmService implements IUserAlgorithmService {
	@Autowired
	private IUserAlgorithmDao userAlgorithmDao;
	@Autowired
	private IUserDao userDao;

	@Override
	public void add(User user,Algorithm algorithm) {
		user.setScore(user.getScore() - algorithm.getScore());
		UserAlgorithm userAlgorithm = new UserAlgorithm();
		userAlgorithm.setUser(user);
		userAlgorithm.setAlgorithm(algorithm);
		userAlgorithm.setDateCreated(new Date());
		userAlgorithm.setDateModified(new Date());
		User user2 = algorithm.getUser();
		user2.setScore(user2.getScore() + algorithm.getScore());
		userDao.updateUser(user);
		userDao.updateUser(user2);
		userAlgorithmDao.add(userAlgorithm);
	}

	@Override
	public UserAlgorithm get(Integer uid, Integer aid) {
		return userAlgorithmDao.get(uid, aid);
	}

}
