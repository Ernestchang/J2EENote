package com.bingoogol.algorithm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_channel")
public class Channel extends GenericBean {
	private static final long serialVersionUID = -4023221876047281178L;
	/**
	 * 栏目的名称
	 */
	private String name;
	/**
	 * 是否是顶级栏目
	 */
	private Boolean isTop;
	/**
	 * 父类栏目
	 */
	private Channel parent;
	
	/**
	 * 状态 2表示待审核，1表示通过，0表示未通过
	 */
	private Integer status;
	/**
	 * 子栏目，不保存到数据库
	 */
	private List<Channel> childrens = new ArrayList<Channel>();
	@Column(unique=true,nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "is_top",nullable = false)
	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	@ManyToOne
	@JoinColumn(name = "pid")
	public Channel getParent() {
		return parent;
	}

	public void setParent(Channel parent) {
		this.parent = parent;
	}
	
	@Column(nullable = false)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Transient
	public List<Channel> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Channel> childrens) {
		this.childrens = childrens;
	}
}
