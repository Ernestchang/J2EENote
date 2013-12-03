package com.bingoogol.algorithm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingoogol.algorithm.dao.IQuestionDao;
import com.bingoogol.algorithm.model.Question;
import com.bingoogol.algorithm.service.IQuestionService;

@Service("questionService")
public class QuestionService implements IQuestionService {
	@Autowired
	private IQuestionDao questionDao;

	public void addQuestion(Question question) {
		questionDao.addQuestion(question);
	}
}
