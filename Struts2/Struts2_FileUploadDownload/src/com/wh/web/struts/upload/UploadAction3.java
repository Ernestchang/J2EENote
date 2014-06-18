package com.wh.web.struts.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/*
 * Struts2的文件上传实际上是通过FileUploadInterceptor拦截器来处理的
 */
public class UploadAction3 extends ActionSupport {
	private static final long serialVersionUID = -8796327452281457412L;
	private String username;
//	与客户端所传文件的名字一样
//	file1:<input type="file" name="file"><br>
//	file2:<input type="file" name="file"><br>
//	file3:<input type="file" name="file"><br>
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	@Override
	public String execute() throws Exception {
		String uploadpath = ServletActionContext.getServletContext().getRealPath("/file");
		System.out.println("上传目录:" + uploadpath);
		
		for(int i = 0; i < file.size(); i++) {
			InputStream is = new FileInputStream(file.get(i));
			System.out.println("临时文件:" + file.get(i).getAbsolutePath());
			
			File destFile = new File(uploadpath,fileFileName.get(i));
			if(!destFile.getParentFile().exists()) {
				destFile.mkdirs();
			}
			OutputStream os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int len = 0;
			while((len = is.read(buffer)) != -1) {
				System.out.println("--------------写入中--------------");
				os.write(buffer,0,len);
			}
			os.close();
			is.close();
		}
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}
	public List<String> getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}
	public List<String> getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
}
