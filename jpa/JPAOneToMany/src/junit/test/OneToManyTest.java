package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import cn.wh.bean.Order;
import cn.wh.bean.OrderItem;



public class OneToManyTest {

	@Test public void save() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Order order = new Order();
		order.setAmount(34f);
		order.setOrderid("999");
		OrderItem orderItem = new OrderItem();
		orderItem.setProcutName("足球");
		orderItem.setSellPrice(90f);
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProcutName("蓝球");
		orderItem2.setSellPrice(90f);
		order.addOrderItem(orderItem);
		order.addOrderItem(orderItem2);
		em.persist(order);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
