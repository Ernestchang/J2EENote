package com.wh.web.struts.upload;

import org.apache.struts2.ServletActionContext;
import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
/*
 * Struts2在进行文件上传操作时，实际上是通过两个步骤实现的：
 * 1.首先将客户端上传的文件保存到struts.multipart.saveDir键所指定的目录中，如该键所对应的
 * 目录不存在，那么就保存到javax.servlet.context.tempdir环境变量所指定的目录中
 * 2.Action中所定义的File类型的成员变量file实际上指向的是临时目录中的临时文件，人后在服务器端
 * 通过IO的方式将临时文件写入到指定的服务器端目录中
 */
public class UploadAction1 extends ActionSupport {
	private static final long serialVersionUID = -2432616080102187708L;
	private String username;
	//指向最开始保存到临时目录下的临时文件
	private File file;
	//<input type="file" name="file">
	private String fileFileName;
	private String fileContentType;
	public String execute() throws Exception {
		String uploadpath = ServletActionContext.getServletContext().getRealPath("/file");
		System.out.println("上传目录:" + uploadpath);
		InputStream is = new FileInputStream(file);
		System.out.println("临时文件:" + file.getAbsolutePath());
		
		File destFile = new File(uploadpath,fileFileName);
		if(!destFile.getParentFile().exists()) {
			destFile.mkdirs();
		}
		
		OutputStream os = new FileOutputStream(destFile);
		byte[] buffer = new byte[400];
		int len = 0;
		while((len = is.read(buffer)) != -1) {
			os.write(buffer,0,len);
		}
		os.close();
		is.close();
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
}
