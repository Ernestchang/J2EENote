package cn.wh.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IDCard {

	private Integer id;
	private String cardno;
	private Person person;
	public IDCard() {}
	public IDCard(String cardno) {
		this.cardno = cardno;
	}
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=18,nullable=false)
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	//FetchType.LAZY：懒加载,FetchType.EAGER：急加载
	@OneToOne(
		mappedBy="idcard",fetch=FetchType.EAGER
		,cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}
	)
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
