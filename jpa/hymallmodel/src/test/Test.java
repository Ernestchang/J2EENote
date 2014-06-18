package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;

public class Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		//hibernate中得到sessionFactory后就会创建表，sessionFactory-->session-->begin事务
		EntityManager em = emf.createEntityManager();
	}
	
	@org.junit.Test
	public void test() {
	}
}
