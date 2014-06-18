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
import com.wh.bean.Person;

public class GetXmlAction extends ActionSupport {
	private static final long serialVersionUID = -8236060086120332048L;
	private String name;
	private Person person1;
	private Person person2;
	private Document document;
	@Override
	public String execute() throws Exception {
		buildPerson();
		//代表整个xml文档
		document = DocumentHelper.createDocument();
		//代表文档根元素
		Element rootElement = document.addElement("users");
		//增加一个注释
		rootElement.addComment("This is a comment!");
		Element userElement = rootElement.addElement("user");
		Element idElement = userElement.addElement("id");
		Element nameElement = userElement.addElement("name");
		Element ageElement = userElement.addElement("age");
		Element addressElement = userElement.addElement("address");
		if("zhangsan".equals(name)) {
			idElement.setText(person1.getId() + "");
			nameElement.setText(person1.getName());
			ageElement.setText(person1.getAge() + "");
			addressElement.setText(person1.getAddress());
		} else {
			idElement.setText(person2.getId() + "");
			nameElement.setText(person2.getName());
			ageElement.setText(person2.getAge() + "");
			addressElement.setText(person2.getAddress());
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter xmlWriter = new XMLWriter(out, format);
		xmlWriter.write(document);
		out.flush();
		out.close();
		return null;
	}
	private void buildPerson() {
		/*
			<users>
			<user>
			<id>1</id>
			<name>zhangsan</name>
			<age>20</age>
			<address>shanghai</address>
			</user>
			</users>
		 */
		//zhangsan
		person1 = new Person();
		person1.setId(1);
		person1.setName("zhangsan");
		person1.setAge(20);
		person1.setAddress("shanghai");
		//lisi
		person2 = new Person();
		person2.setId(2);
		person2.setName("lisi");
		person2.setAge(30);
		person2.setAddress("chongqing");
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
