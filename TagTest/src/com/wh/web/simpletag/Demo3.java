//�޸ı�ǩ��
package com.wh.web.simpletag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo3 extends SimpleTagSupport {
	/*
	�����ڱ�ǩ���������޸ı�ǩ�����ݣ�
	���ڵ���invoke������ָ��һ����ȡ��������ݵ����������
	�ñ�ǩ���ִ�н���������������У�Ȼ��Ӹ����������
	��ȡ�����ݽ����޸ĺ��������Ŀ���豸  
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
