//���Ʊ�ǩ�Ƿ�ִ��
/*
 * �����򵥱�ǩ
 * 1.ʵ������ǩ��������
 * 2.����setJspContext����ҳ��pageContext���ݸ���ǩ��������
 * 3.����setParent�Ѹ���ǩ���ݽ�ȥ�����û�и��ף���null
 * 4.����setJspBody�������ѷ�װ�˱�ǩ��JspFragment���ݸ���ǩ��������
 * 5.ִ��ҳ���е��Զ����ǩ��ִ�б�ǩʵ���Ͼ��ǵ���dotag����
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
		�÷����Ĳ���out����ָ����JspFragment�����ִ�н��
		д�뵽�Ǹ�����������С������ݲ���out��ֵΪnull����
		��ִ�н��д�뵽JspContext.getOut()�������ص������
		������
		*/
		jf.invoke(out);
	}
	
}
