//属性的标签
package com.wh.web.simpletag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5 extends SimpleTagSupport {

	private int count;
	private Date date;

	public void setCount(int count) {
		this.count = count;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		this.getJspContext().getOut().write(sdf.format(date) + "</br>");
		for(int i = 0; i < count; i++) {
			jf.invoke(this.getJspContext().getOut());
		}
	}

	
	
}
