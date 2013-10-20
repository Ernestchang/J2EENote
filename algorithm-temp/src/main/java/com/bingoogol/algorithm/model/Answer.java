package com.bingoogol.algorithm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 算法提问的答案实体
 * 
 * @author bingoogol
 * 
 */
@Entity
@Table(name = "t_answer")
public class Answer extends GenericBean {
	private static final long serialVersionUID = 5098230625724397077L;
	/**
	 * 回答者
	 */
	private User user;
	/**
	 * 回答的内容
	 */
	private String content;
	/**
	 * 所属问题
	 */
	private Question question;

	@ManyToOne
	@JoinColumn(name = "uid", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "qid")
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
