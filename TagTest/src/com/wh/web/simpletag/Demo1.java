//控制标签是否执行
/*
 * 遇到简单标签
 * 1.实例化标签处理器类
 * 2.调用setJspContext，把页面pageContext传递给标签处理器类
 * 3.调用setParent把父标签传递进去，如果没有父亲，传null
 * 4.调用setJspBody方法，把封装了标签体JspFragment传递给标签处理器类
 * 5.执行页面中的自定义标签，执行标签实际上就是调用dotag方法
 * */
package com.wh.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo1 extends SimpleTagSupport {
	private JspContext jspContext;
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		jspContext = this.getJspContext();
		JspWriter out = jspContext.getOut();
		/*
		该方法的参数out用于指定将JspFragment对象的执行结果
		写入到那个输出流对象中。若传递参数out的值为null，则
		将执行结果写入到JspContext.getOut()方法返回的输出流
		对象中
		*/
		jf.invoke(out);
	}
	
}
