package com.bingoogol.algorithm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 算法评论实体
 * 
 * @author bingoogol
 * 
 */
@Entity
@Table(name = "t_comment")
public class Comment extends GenericBean {
	private static final long serialVersionUID = 5098230625724397077L;
	/**
	 * 评论者
	 */
	private User user;
	/**
	 * 评论的内容
	 */
	private String content;
	/**
	 * 该评论对应的算法
	 */
	private Algorithm algorithm;

	@ManyToOne
	@JoinColumn(name = "uid")
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
	@JoinColumn(name = "aid")
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

}
