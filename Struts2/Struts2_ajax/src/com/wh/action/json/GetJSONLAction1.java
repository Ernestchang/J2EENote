package com.wh.action.json;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.bean.People;


public class GetJSONLAction1 extends ActionSupport {
	private static final long serialVersionUID = 1535613639487469371L;
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
		Gson gson = new Gson();
		String result = null;
		if("zhangsan".equals(name)) {
			result = gson.toJson(people1);
		} else if("lisi".equals(name)) {
			result = gson.toJson(people2);
		} else if("wangwu".equals(name)) {
			result = gson.toJson(people3);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		System.out.println(result);
		out.print(result);
		out.flush();
		out.close();
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
