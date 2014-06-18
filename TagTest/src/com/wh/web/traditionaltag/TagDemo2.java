//控制整个jsp是否输出
package com.wh.web.traditionaltag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo2 extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		
		return Tag.SKIP_PAGE;
	}
	
}
