package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import cn.wh.bean.AirLine;


public class AirLineTest {

	@Test public void save() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(new AirLine("PEK", "SHA", "北京飞上海"));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
