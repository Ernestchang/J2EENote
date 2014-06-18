package com.bingoogol.generic.dao.test;

import java.sql.Connection;

import javax.inject.Inject;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.bingoogol.generic.dao.ICustomerDao;
import com.bingoogol.generic.model.Customer;
import com.bingoogol.generic.test.util.AbstractDbUnitTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestCustomerDaoHibernate extends AbstractDbUnitTestCase {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private ICustomerDao customerDao;

	@Inject
	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		dbunitCon = new DatabaseConnection(conn);

		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		this.backupAllTable();
		IDataSet ds = createDateSet("t_customer");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	}

	@After
	public void tearDown() throws Exception {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession();
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
		DataSourceUtils.releaseConnection(dbunitCon.getConnection(), jdbcTemplate.getDataSource());
	}

	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setUsername("王浩");
		customer.setPassword("123456");
		customerDao.add(customer);
		Customer customer2 = customerDao.load(12);
		System.out.println(customer2.getUsername());
	}

	@Test
	public void testLoad() {
		Customer customer = customerDao.load(1);
		System.out.println(customer.getUsername());
	}

}
