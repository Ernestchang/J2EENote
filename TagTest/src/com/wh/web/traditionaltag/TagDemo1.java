//控制标签体是否输出
package com.wh.web.traditionaltag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo1 extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		
		return Tag.EVAL_BODY_INCLUDE;
//		return Tag.SKIP_BODY;
	}

}
