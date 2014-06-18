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
import javax.persistence.Table;
/**
 * 权限组实体
 * @author 496312716@qq.com
 *
 */
@Entity
@Table(name="privilegegroup")
public class PrivilegeGroup {
	/**
	 * 主键
	 */
	private String groupid;
	/**
	 * 权限组名称
	 */
	private String name;
	/**
	 * 权限组的权限
	 */
	private Set<SystemPrivilege> privileges = new HashSet<SystemPrivilege>();
	/**
	 * 拥有该权限组的用户
	 */
	private Set<User> users = new HashSet<User>();
	public PrivilegeGroup(){}
	
	public PrivilegeGroup(String groupid) {
		this.groupid = groupid;
	}
	@Id @Column(length=36)
	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	@Column(length=8,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(
		name="pg_sp",
		inverseJoinColumns={
			@JoinColumn(name="module", referencedColumnName="module"),
			@JoinColumn(name="privilege", referencedColumnName="privilege")},
		joinColumns=@JoinColumn(name="group_id"))
	public Set<SystemPrivilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<SystemPrivilege> privileges) {
		this.privileges = privileges;
	}
	@ManyToMany(mappedBy="groups", cascade=CascadeType.REFRESH)
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupid == null) ? 0 : groupid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrivilegeGroup other = (PrivilegeGroup) obj;
		if (groupid == null) {
			if (other.groupid != null)
				return false;
		} else if (!groupid.equals(other.groupid))
			return false;
		return true;
	}
}
