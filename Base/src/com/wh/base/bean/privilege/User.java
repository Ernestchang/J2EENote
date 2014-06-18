package com.wh.base.bean.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wh.base.bean.Reply;
import com.wh.base.bean.Topical;
import com.wh.base.utils.WebUtil;

@Entity
@Table(name="user")
public class User {
	private String username;
	private String realname;
	private String password;
	private String picture;
	private Set<Reply> replys = new HashSet<Reply>();
	private Set<Topical> topicals = new HashSet<Topical>();
	private Set<PrivilegeGroup> groups = new HashSet<PrivilegeGroup>();
	@Id @Column(length=10,nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(length=5,nullable=false)
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Column(length=32,nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=40)
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@OneToMany(
			cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
			,fetch=FetchType.LAZY,mappedBy="user"
		)
	public Set<Reply> getReplys() {
		return replys;
	}
	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}
	@OneToMany(
			cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
			,fetch=FetchType.LAZY,mappedBy="user"
		)
	public Set<Topical> getTopicals() {
		return topicals;
	}
	public void setTopicals(Set<Topical> topicals) {
		this.topicals = topicals;
	}
	@ManyToMany(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	@JoinTable(name="user_pg",
		inverseJoinColumns=@JoinColumn(name="group_id"),
		joinColumns=@JoinColumn(name="username"))
	public Set<PrivilegeGroup> getGroups() {
		return groups;
	}
	public void setGroups(Set<PrivilegeGroup> groups) {
		this.groups = groups;
	}
	@Transient
	public String getImageFullPath(){
		if(null == picture) {
			return WebUtil.getContextPath() + "/file/picture/default.jpg";
		}
		return WebUtil.getContextPath() + "/file/picture/"+ username + "/prototype/" + picture;
	}
}
