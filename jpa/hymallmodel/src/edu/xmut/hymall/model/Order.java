package edu.xmut.hymall.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseBean implements Serializable {
	private static final long serialVersionUID = -3720915805000395563L;
	private Customer customer;
	private List<LineItem> lineItems = new ArrayList<LineItem>();
}
