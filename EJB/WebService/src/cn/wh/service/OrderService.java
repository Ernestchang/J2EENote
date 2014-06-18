package cn.wh.service;

import java.util.List;

import cn.wh.bean.Order;

public interface OrderService {

	public String getUserName(String name);
	public Order getOrder(String orderid);
	public List<Order> getOrders();
}
