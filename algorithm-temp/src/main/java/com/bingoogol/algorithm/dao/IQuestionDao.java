package com.bingoogol.algorithm.dao;

import com.bingoogol.algorithm.model.Question;


public interface IQuestionDao {
	/**
	 * 添加问题
	 * @param question 问题实体
	 */
	public void addQuestion(Question qustion);
}
