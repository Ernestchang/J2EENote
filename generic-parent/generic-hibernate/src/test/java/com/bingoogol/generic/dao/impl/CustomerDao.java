package com.bingoogol.generic.dao.impl;

import org.springframework.stereotype.Repository;

import com.bingoogol.generic.dao.GenericDao;
import com.bingoogol.generic.dao.ICustomerDao;
import com.bingoogol.generic.model.Customer;

@Repository("customerDao")
public class CustomerDao extends GenericDao<Customer> implements ICustomerDao {
	
}
