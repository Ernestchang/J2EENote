package com.bingoogol.algorithmhome.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class AddAlgorithmDto {
	private String name;
	private String summary;
	private String author1;
	private String author2;
	private String author3;
	private int price;
	private String code;
	private String codeName;
	private String codeHash;
	private String iodata;
	private String iodataName;
	private String iodataHash;
	private String thesis;
	private String thesisName;
	private String thesisHash;
	private int cid;
	private String vcode;
	private String uid;
	private String id;

	@NotEmpty
	@Length(min = 2)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty
	@Length(min = 15, max = 150)
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAuthor1() {
		return author1;
	}

	public void setAuthor1(String author1) {
		this.author1 = author1;
	}

	public String getAuthor2() {
		return author2;
	}

	public void setAuthor2(String author2) {
		this.author2 = author2;
	}

	public String getAuthor3() {
		return author3;
	}

	public void setAuthor3(String author3) {
		this.author3 = author3;
	}

	@NotNull
	@Min(0)
	@Max(100)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@NotEmpty
	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@NotEmpty
	public String getCodeHash() {
		return codeHash;
	}

	public void setCodeHash(String codeHash) {
		this.codeHash = codeHash;
	}

	public String getIodata() {
		return iodata;
	}

	public void setIodata(String iodata) {
		this.iodata = iodata;
	}

	@NotEmpty
	public String getIodataName() {
		return iodataName;
	}

	public void setIodataName(String iodataName) {
		this.iodataName = iodataName;
	}

	@NotEmpty
	public String getIodataHash() {
		return iodataHash;
	}

	public void setIodataHash(String iodataHash) {
		this.iodataHash = iodataHash;
	}

	public String getThesis() {
		return thesis;
	}

	public void setThesis(String thesis) {
		this.thesis = thesis;
	}

	@NotEmpty
	public String getThesisName() {
		return thesisName;
	}

	public void setThesisName(String thesisName) {
		this.thesisName = thesisName;
	}

	@NotEmpty
	public String getThesisHash() {
		return thesisHash;
	}

	public void setThesisHash(String thesisHash) {
		this.thesisHash = thesisHash;
	}

	@NotNull
	@Min(1)
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9]{4}")
	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
