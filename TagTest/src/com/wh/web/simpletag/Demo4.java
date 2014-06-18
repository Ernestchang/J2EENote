//让整个页面不执行
package com.wh.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
	
}
