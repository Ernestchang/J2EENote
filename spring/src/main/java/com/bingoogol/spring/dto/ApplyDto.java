package com.bingoogol.spring.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ApplyDto {
	private String title;
	private String degree;
	private String summary;
	private String realname;
	private String vcode;
	private String approve;
	private String approveName;
	private String approveHash;
	private int cid;
	private String uid;

	@NotEmpty
	@Length(min = 2)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotEmpty
	@Length(min = 2)
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@NotEmpty
	@Length(min = 15, max = 150)
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@NotEmpty
	@Length(min = 2)
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9]{4}")
	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	@NotEmpty
	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}

	@NotEmpty
	public String getApproveHash() {
		return approveHash;
	}

	public void setApproveHash(String approveHash) {
		this.approveHash = approveHash;
	}

	@NotNull
	@Min(1)
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}