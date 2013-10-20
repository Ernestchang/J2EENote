package com.bingoogol.algorithm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User extends GenericUser {
	private static final long serialVersionUID = -1294732724285318741L;
	/**
	 * 用户的邮件
	 */
	private String email;
	/**
	 * 用户积分
	 */
	private Integer score;
	/**
	 * 用户的研究方向
	 */
	private Channel channel;
	
	@Column(nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(nullable = false)
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@ManyToOne
	@JoinColumn(name = "cid")
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
