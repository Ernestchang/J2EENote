package cn.wh.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	private String orderid;
	private Float amount = 0f;
	private Set<OrderItem> items = new HashSet<OrderItem>();
	//目前jpa规范并不提供uuid这种生产策略，只提供整型
	@Id @Column(length=12)
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@Column(nullable=false)
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	/*
	 * 某某某ToMany默认的都是延迟加载
	 * 某某某ToOne默认的都是立即加载
	 * mappedBy指定为被维护端，值为维护端实体中的某个属性(此处为OrderItem中的Order对象)
	 */
	@OneToMany(
		cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
		,fetch=FetchType.LAZY,mappedBy="order"
	)
	public Set<OrderItem> getItems() {
		return items;
	}
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	public void addOrderItem(OrderItem orderItem) {
		orderItem.setOrder(this);
		this.items.add(orderItem);
	}
}
