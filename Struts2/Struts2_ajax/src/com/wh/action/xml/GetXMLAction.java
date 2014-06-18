package com.wh.action.xml;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.opensymphony.xwork2.ActionSupport;
import com.wh.bean.People;


public class GetXMLAction extends ActionSupport {
	private static final long serialVersionUID = 5712604564878408058L;
	private String name;
	@Override
	public String execute() throws Exception {
		People people1 = new People();
		people1.setId(1);
		people1.setName("zhangsan");
		people1.setAge(30);
		people1.setAddress("beijing");
		People people2 = new People();
		people2.setId(2);
		people2.setName("lisi");
		people2.setAge(40);
		people2.setAddress("tianjing");
		People people3 = new People();
		people3.setId(3);
		people3.setName("wangwu");
		people3.setAge(50);
		people3.setAddress("shanghai");
		Document document = DocumentHelper.createDocument();
		Element rootElement = document.addElement("persons");
		rootElement.addComment("This is comment");
		Element e = rootElement.addElement("person");
		Element idElement = e.addElement("id");
		Element nameElement = e.addElement("name");
		Element ageElement = e.addElement("age");
		Element addressElement = e.addElement("address");
		if("zhangsan".equals(name)) {
			idElement.setText(people1.getId() + "");
			nameElement.setText(people1.getName());
			ageElement.setText(people1.getAge() + "");
			addressElement.setText(people1.getAddress());
		} else if("lisi".equals(name)) {
			idElement.setText(people2.getId() + "");
			nameElement.setText(people2.getName());
			ageElement.setText(people2.getAge() + "");
			addressElement.setText(people2.getAddress());
		} else if("wangwu".equals(name)) {
			idElement.setText(people3.getId() + "");
			nameElement.setText(people3.getName());
			ageElement.setText(people3.getAge() + "");
			addressElement.setText(people3.getAddress());
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		//格式化xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		out.flush();
		out.close();
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("name:" + name);
		this.name = name;
	}
}
