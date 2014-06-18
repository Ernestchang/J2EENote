package cn.wh.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AirLine {

	private AirLinePK id;
	private String name;
	public AirLine() {}
	public AirLine(String startCity, String endCity, String name) {
		this.id = new AirLinePK(startCity, endCity);
		this.name = name;
	}
	//@EmbeddedId用于这个属性为实体标示符
	@EmbeddedId
	public AirLinePK getId() {
		return id;
	}
	public void setId(AirLinePK id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
