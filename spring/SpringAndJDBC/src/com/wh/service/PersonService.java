package com.wh.service;

import java.util.List;

import com.wh.bean.Person;

public interface PersonService {
	public void save(Person person);
	public void update(Person person);
	public Person getPerson(Integer personid);
	public List<Person> getPersons();
	public void delete(Integer personid) throws Exception;
}
