package com.bingoogol.algorithm.dao.impl;

import org.springframework.stereotype.Repository;

import com.bingoogol.algorithm.dao.IQuestionDao;
import com.bingoogol.algorithm.model.Question;

@Repository("questionDao")
public class QuestionDao extends GenericDao<Question> implements IQuestionDao {

	public void addQuestion(Question question) {
		super.add(question);
	}
}
