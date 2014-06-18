//修改标签体
package com.wh.web.simpletag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo3 extends SimpleTagSupport {
	/*
	若想在标签处理器中修改标签的内容：
	需在调用invoke方法是指定一个可取出结果数据的输出流对象
	让标签体的执行结果输出到该输出流中，然后从该输出流对象
	中取出数据进行修改后在输出到目标设备  
	*/
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		StringWriter sw = new StringWriter();
		jf.invoke(sw);
		String content = sw.toString();
		content = content.toUpperCase();
		this.getJspContext().getOut().write(content);
	}
	
}
