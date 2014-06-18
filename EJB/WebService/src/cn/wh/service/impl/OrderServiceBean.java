package cn.wh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import cn.wh.bean.Order;
import cn.wh.service.OrderService;
@WebService
@Stateless
@Remote(OrderService.class)
public class OrderServiceBean implements OrderService {

	//如果在这里使用@WebMethod，其余的方法将不会编程WebService方法
	public String getUserName(String name) {
		return name;
	}
	public Order getOrder(String orderid) {
		Order order = new Order();
		order.setName("视频1");
		order.setOrderid(orderid);
		return order;
	}
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();
		Order order1 = new Order();
		order1.setName("视频1");
		order1.setOrderid("001");
		Order order2 = new Order();
		order2.setName("视频2");
		order2.setOrderid("002");
		orders.add(order1);
		orders.add(order2);
		return orders;
	}

}
