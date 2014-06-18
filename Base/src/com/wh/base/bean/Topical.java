package com.wh.base.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wh.base.bean.privilege.User;
@Entity
@Table(name="topical")
public class Topical {
	private Integer id;
	private String content;
	private User user;
	private Set<Reply> replys = new HashSet<Reply>();
	public Topical() {}
	public Topical(String content, User user) {
		this.content = content;
		this.user = user;
	}
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=30,nullable=false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*
	 * 某某某ToMany默认的都是延迟加载
	 * 某某某ToOne默认的都是立即加载
	 * mappedBy指定为被维护端，值为维护端实体中的某个属性
	 */
	@OneToMany(
		cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
		,fetch=FetchType.LAZY,mappedBy="topical"
	)
	public Set<Reply> getReplys() {
		return replys;
	}
	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}
	
}
