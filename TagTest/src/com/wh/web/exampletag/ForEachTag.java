package com.wh.web.exampletag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {
	private String var;
	private Object items;
	private Collection collection;
	public void setVar(String var) {
		this.var = var;
	}
	public void setItems(Object items) {
		this.items = items;
		if(items instanceof Collection) {
			collection = (Collection) items;
		}
		if(items instanceof Map) {
			Map map = (Map) items;
			collection = map.entrySet();
		}
		if(items.getClass().isArray()) {
			this.collection = new ArrayList();
			int length = Array.getLength(items);
			for(int i = 0 ;i < length; i++) {
				Object value = Array.get(items, i);
				this.collection.add(value);
			}
		}
	}
	@Override
	public void doTag() throws JspException, IOException {
		Iterator it = this.collection.iterator();
		while(it.hasNext()) {
			Object value = it.next();
			this.getJspContext().setAttribute(var, value);
			this.getJspBody().invoke(null);
		}
	}
	
}
