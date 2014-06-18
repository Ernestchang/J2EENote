/*
 * 1-m
 * 多的一方为关系维护端，
 * 关系维护端负责外键记录的更新
 * 关系被维护端是没有权力更新外键记录的
 */
package cn.wh.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	private Integer id;
	private String procutName;
	private Float sellPrice;
	private Order order;
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=40,nullable=false)
	public String getProcutName() {
		return procutName;
	}
	public void setProcutName(String procutName) {
		this.procutName = procutName;
	}
	@Column(nullable=false)
	public Float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
