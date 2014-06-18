package cn.wh.service.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cn.wh.bean.Person;
import cn.wh.service.PersonService;

@Stateless
@Remote(PersonService.class)
public class PersonServiceBean implements PersonService {

	@PersistenceContext(unitName="wanghao") EntityManager em;
	
	public void save(Person person) {
		em.persist(person);
	}

	public void update(Person person) {
		//如果对象处于托管状态，我们只需要调用它的set方法就可以进行修改，无需调用merge方法
		em.merge(person);
	}

	public void delete(Integer personid) {
		em.remove(em.getReference(Person.class, personid));
	}

	public Person getPerson(Integer personid) {
		return em.find(Person.class, personid);
	}

	//select o from 实体Bean（区分大小写） o
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return em.createQuery("select o from Person o").getResultList();
	}

}
