package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import cn.wh.bean.Student;
import cn.wh.bean.Teacher;


public class ManyToManyTest {
	
	@Test public void save() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(new Student("学生1"));
		em.persist(new Teacher("老师1"));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	/**
	 * 建立学生跟老师的关系
	 */
	@Test public void buildTS() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		student.addTeacher(em.getReference(Teacher.class, 1));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	/**
	 * 解除学生跟老师的关系
	 */
	@Test public void deleteTS() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		student.removeTeacher(em.getReference(Teacher.class, 1));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	/**
	 * 删除老师
	 */
	@Test public void deleteTeacher() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		Teacher teacher = em.getReference(Teacher.class, 1);
		student.removeTeacher(teacher);
		em.remove(teacher);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	/**
	 * 删除学生
	 */
	@Test public void deleteStudent() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanghao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.getReference(Student.class, 1);
		em.remove(student); //hibernate判断出Student是关系维护端，hibernate会先把关联记录删掉再删该对象
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
