package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import cn.wh.bean.Person;

//getReference找不到记录的时候会抛出异常，find方法找不到记录的时候会返回null

public class PersonTest {
	
	@Test public void save() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		//hibernate中得到sessionFactory后就会创建表，sessionFactory-->session-->begin事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(new Person("厦门理工"));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@Test public void getPerson() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		//hibernate中得到sessionFactory后就会创建表，sessionFactory-->session-->begin事务
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, 1);  //相当于hibernate中的get方法
		/*
		 * 如果再次执行find方法会从em的一级缓存中取该对象
		 * 执行某操作用了一分钟，如果还想获取到数据库中的最新数据就要用em.refresh(person);
		 */
		System.out.println(person.getName());
		em.close();
		emf.close();
	}
	@Test public void getPerson2() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		//hibernate中得到sessionFactory后就会创建表，sessionFactory-->session-->begin事务
		EntityManager em = emf.createEntityManager();
		Person person = em.getReference(Person.class, 1); //相当于hibernate中的load方法，延迟加载
		System.out.println(person.getName());  //当执行这条语句时才进行数据加载
		em.close();
		emf.close();
	}
	@Test public void updatePerson() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person = em.find(Person.class, 1);
		person.setName("王浩");   //new manage(托管） 游离 删除
		//如果对象处于托管状态，我们只需要调用它的set方法就可以进行修改，无需调用merge方法
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@Test public void updatePerson2() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person = em.find(Person.class, 1);
		em.clear();  //把实体管理器中的所有实体对象变成游离状态
		person.setName("小星星2");
		System.out.println("会根据id重新从数据库获取实体");
		em.merge(person); //把游离状态时候的更新同步回数据库
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@Test public void updatePerson3() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person = new Person();
		person.setId(1);
		person.setName("小星星");
		System.out.println("会根据id重新从数据库获取实体");
		/*
		 * merge类似Hibernate中的saveOrUpdate方法
		 * 一般的作用是合并已经被 EntityManager 脱管的对象合并到数据库中去
		 * 如果数据库中不存在则执行类似于persist的操作。
		 */
		em.merge(person);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@Test public void delete() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person = em.find(Person.class, 1);
		em.remove(person); //要删除的实体处于托管状态
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@Test public void query() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select o from Person o where o.id=?10");
		query.setParameter(10, 2);
		//Person person = (Person) query.getResultList().get(0);
		Person person = (Person) query.getSingleResult();
		System.out.println(person.getName());
		em.close();
		emf.close();
	}
	@Test public void deletequery() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("delete from Person o where o.id=?10");
		query.setParameter(10, 2);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@Test public void updatequery() {
		//jpa中执行这句话后就会创建表
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();    // select count(o) from Person o;
		Query query = em.createQuery("update Person o set o.name=:name where o.id=:id");
		query.setParameter("name", "xxxx");
		query.setParameter("id", 3);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
