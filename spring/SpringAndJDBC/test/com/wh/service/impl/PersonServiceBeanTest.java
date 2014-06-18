package com.wh.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wh.bean.Person;
import com.wh.service.PersonService;

public class PersonServiceBeanTest {
	private static PersonService personService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
		personService = (PersonService) cxt.getBean("personService");
	}

	@Test
	public void testSave() {
		personService.save(new Person("王浩"));
	}

	@Test
	public void testUpdate() {
		Person person = personService.getPerson(3);
		person.setName("呵呵");
		personService.update(person);
	}

	@Test
	public void testGetPerson() {
		Person person = personService.getPerson(3);
		System.out.println(person.getName());
	}

	@Test
	public void testGetPersons() {
		for(Person person : personService.getPersons()) {
			System.out.println(person.getName());
		}
	}

	@Test
	public void testDelete() {
		try {
			personService.delete(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
