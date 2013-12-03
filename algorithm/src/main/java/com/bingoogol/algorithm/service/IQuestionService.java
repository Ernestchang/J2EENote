package com.bingoogol.algorithm.service;

import com.bingoogol.algorithm.model.Question;


public interface IQuestionService {
	/**
	 * 添加问题
	 * @param question 问题实体
	 */
	public void addQuestion(Question question);
}
