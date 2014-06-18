package com.wh.web.struts.download;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	private static final long serialVersionUID = 2374318864754519363L;
	private String fileName;
	public InputStream getDownloadFile() {
		InputStream is = null;
		this.fileName = "课表.png";
		is = ServletActionContext.getServletContext().getResourceAsStream("/file/" + fileName);
		try {
			this.fileName = new String(this.fileName.getBytes("gbk"),"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return is;
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
