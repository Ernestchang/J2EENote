package cn.wh.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="person")
public class Person {
	private Integer id;
	private String name;
	private Date brithday;
	private Gender gender = Gender.MAN;
	private String info;
	private Byte[] file;
	private String imagepath;
	public Person() {}
	public Person(String name) {
		this.name = name;
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=10,nullable=false,name="personName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Temporal(TemporalType.DATE)
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	@Enumerated(EnumType.STRING)
	@Column(length=5,nullable=false)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Lob  //大文本字段
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Lob @Basic(fetch=FetchType.LAZY) //存放二进制数据字段
	public Byte[] getFile() {
		return file;
	}
	public void setFile(Byte[] file) {
		this.file = file;
	}
	@Transient  //不和数据库表做映射
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
}
