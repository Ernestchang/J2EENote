//修改标签体（把标签体改为大写）
package com.wh.web.traditionaltag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagDemo4 extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		
		return BodyTag.EVAL_BODY_BUFFERED;
	}

	@Override
	public int doEndTag() throws JspException {
		//得到标签体
		BodyContent bc = this.getBodyContent();
		String content = bc.getString();
		content = content.toUpperCase();
		
		try {
			this.pageContext.getOut().write(content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return Tag.EVAL_PAGE;
	}

}
