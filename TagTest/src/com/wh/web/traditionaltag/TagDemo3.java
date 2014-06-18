//控制标签体执行5次
package com.wh.web.traditionaltag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo3 extends TagSupport {

	private static final long serialVersionUID = 1L;
	int x = 5;
	@Override
	public int doStartTag() throws JspException {
		
		return Tag.EVAL_BODY_INCLUDE;
	}

	//标签体执行之后，结束标记执行之前
	@Override
	public int doAfterBody() throws JspException {
		
		x--;
		if(x > 0) {
			return IterationTag.EVAL_BODY_AGAIN;
		} else {
			return IterationTag.SKIP_BODY;
		}
	}

}
