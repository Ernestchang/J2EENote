package com.bingoogol.spring.dto;

import java.io.Serializable;

/**
 * 专门用来返回Ajax处理之后结果json数据的对象
 * 
 * @author bingoogol@sina.com
 */
public class AjaxObj implements Serializable {
	private static final long serialVersionUID = 7428653238352567855L;
	/**
	 * 是否成功
	 */
	private boolean success = false;
	/**
	 * 提示信息
	 */
	private String msg = "";
	/**
	 * 附加对象，用来存储一些特定的返回信息
	 */
	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
