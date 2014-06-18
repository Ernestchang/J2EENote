package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import cn.wh.bean.IDCard;
import cn.wh.bean.Person;


public class OneToOneTest {

	@Test public void save() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person = new Person("王浩");
		person.setIdcard(new IDCard("500222199108023713"));
		em.persist(person);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
