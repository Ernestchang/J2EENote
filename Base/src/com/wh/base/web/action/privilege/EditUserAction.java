package com.wh.base.web.action.privilege;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.bean.privilege.User;
import com.wh.base.service.user.UserService;
import com.wh.base.utils.FileUtil;
import com.wh.base.utils.SiteUrl;
@Controller
public class EditUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private File picture;
	private String pictureFileName;
	private String pictureContentType;
	private String username;
	private String realname;
	private String password;
	@Override
	public String execute() throws Exception {
		String message = "修改成功";
		String ext = FileUtil.getExt(pictureFileName);
		if(!FileUtil.validateImageFileType(pictureContentType, ext)) {
			message = "文件格式不正确,只允许上传gif/jpg/png/bmp图片";
		} else {
			//构建文件名称
			String fileName = UUID.randomUUID().toString()+ "."+ext;
			FileUtil.saveImageFile(picture, fileName, username);
			User user = userService.find(username);
			user.setPassword(password);
			user.setRealname(realname);
			user.setPicture(fileName);
			userService.update(user);
		}
		System.out.println("临时文件路径：" + picture.getAbsolutePath());
		ActionContext.getContext().put("message", message);
		ActionContext.getContext().put("urladdress", SiteUrl.readUrl("user.list"));
		return "message";
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
