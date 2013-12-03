package com.bingoogol.algorithm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_algorithm")
public class Algorithm extends GenericBean {
	private static final long serialVersionUID = 5098230625724397077L;
	/**
	 * 算法名称
	 */
	private String name;
	/**
	 * 所属分类
	 */
	private Channel channel;
	/**
	 * 算法简介
	 */
	private String intro;
	/**
	 * 算法的积分
	 */
	private Integer score;
	/**
	 * 上传时论文文件的名称
	 */
	private String oldThesisName;
	/**
	 * 服务器上论文文件的名称
	 */
	private String newThesisName;
	/**
	 * 上传时算法文件的名称
	 */
	private String oldAlgirithmName;
	/**
	 * 服务器上算法文件的名称
	 */
	private String newAlgirithmName;
	/**
	 * 上传者
	 */
	private User user;
	/**
	 * 状态 2表示待审核，1表示通过，0表示未通过
	 */
	private Integer status = 2;
	/**
	 * 下载次数
	 */
	private Integer times = 0;

	@Column(nullable = false)
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(nullable = false)
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public String getOldThesisName() {
		return oldThesisName;
	}

	public void setOldThesisName(String oldThesisName) {
		this.oldThesisName = oldThesisName;
	}

	@Column(nullable = false)
	public String getNewThesisName() {
		return newThesisName;
	}

	public void setNewThesisName(String newThesisName) {
		this.newThesisName = newThesisName;
	}

	@Column(nullable = false)
	public String getOldAlgirithmName() {
		return oldAlgirithmName;
	}

	public void setOldAlgirithmName(String oldAlgirithmName) {
		this.oldAlgirithmName = oldAlgirithmName;
	}

	@Column(nullable = false)
	public String getNewAlgirithmName() {
		return newAlgirithmName;
	}

	public void setNewAlgirithmName(String newAlgirithmName) {
		this.newAlgirithmName = newAlgirithmName;
	}

	@Column(nullable = false)
	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Algorithm [name=" + name + ", channel=" + channel.getId() + ", intro=" + intro + ", score=" + score + ", oldThesisName=" + oldThesisName + ", newThesisName=" + newThesisName + ", oldAlgirithmName=" + oldAlgirithmName + ", newAlgirithmName=" + newAlgirithmName + ", user=" + user.getId() + ", status=" + status + "]";
	}
}
