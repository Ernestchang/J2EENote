package com.bingoogol.generic.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_customer")
public class Customer extends User implements Serializable {
	private static final long serialVersionUID = -8975298953207298451L;
	
}
