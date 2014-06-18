package junit.test;

import java.util.List;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.wh.bean.Person;
import cn.wh.service.PersonService;

public class PersonServiceTest {

	private static PersonService personService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			InitialContext ctx = new InitialContext();
			personService = (PersonService) ctx.lookup("PersonServiceBean/remote");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		personService.save(new Person("学生2"));
	}

	@Test
	public void testUpdate() {
		Person person = personService.getPerson(1);
		person.setName("修改后的学生1");
		personService.update(person);
	}

	@Test
	public void testDelete() {
		personService.delete(1);
	}

	@Test
	public void testGetPerson() {
		Person person = personService.getPerson(1);
		System.out.println(person.getName());
	}

	@Test
	public void testGetPersons() {
		List<Person> persons = personService.getPersons();
		for(Person person : persons) {
			System.out.println(person.getName());
		}
	}

}
