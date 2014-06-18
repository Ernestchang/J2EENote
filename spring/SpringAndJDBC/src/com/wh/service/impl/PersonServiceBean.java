package com.wh.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wh.bean.Person;
import com.wh.service.PersonService;
@Transactional
public class PersonServiceBean implements PersonService {
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void save(Person person) {
		jdbcTemplate.update("insert into person(name) values(?)",
				new Object[]{person.getName()},
				new int[]{java.sql.Types.VARCHAR});
	}

	@Override
	@Transactional(noRollbackFor=Exception.class) //注解方式改变默认配置,使不会回滚
	public void update(Person person) {
		jdbcTemplate.update("update person set name=? where id=?",
				new Object[]{person.getName(),person.getId()},
				new int[]{java.sql.Types.VARCHAR,java.sql.Types.INTEGER});
		throw new RuntimeException("运行期异常会回滚");  //unchecked
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)  //默认是REQUIRED
	public Person getPerson(Integer personid) {
		return jdbcTemplate.queryForObject("select * from person where id=?",
				new Object[]{personid},
				new PersonRowMapper());
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Person> getPersons() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	@Override
	@Transactional(rollbackFor=Exception.class) //注解方式改变默认配置，是回滚
	public void delete(Integer personid) throws Exception {
		jdbcTemplate.update("delete from person where id=?",
				new Object[]{personid},
				new int[]{java.sql.Types.INTEGER});
		throw new Exception("不会回滚");  //checked
	}

}
