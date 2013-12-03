package com.bingoogol.algorithm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 算法问题实体
 * 
 * @author bingoogol
 * 
 */
@Entity
@Table(name = "t_question")
public class Question extends GenericBean {
	private static final long serialVersionUID = 5098230625724397077L;
	/**
	 * 问题名称
	 */
	private String title;
	/**
	 * 问题描述
	 */
	private String intro;
	/**
	 * 所属分类
	 */
	private Channel channel;
	/**
	 * 问题的积分
	 */
	private Integer score;
	/**
	 * 最后采纳的答案的id
	 */
	private Integer aid;
	/**
	 * 提问者
	 */
	private User user;

	@Column(nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false)
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@ManyToOne
	@JoinColumn(name = "cid", nullable = false)
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@ManyToOne
	@JoinColumn(name = "uid", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(nullable = false)
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

}
