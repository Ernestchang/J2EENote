package com.bingoogol.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.spring.util.QiniuUtil;

@Controller
@RequestMapping("/qiniu")
public class QiniuController {
	@RequestMapping(value = "/auth/getPublicUpToken", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String getPublicUpToken() {
		return QiniuUtil.getPublicUpToken();
	}

	@RequestMapping(value = "/auth/getPrivateUpToken", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String getPrivateUpToken() {
		return QiniuUtil.getPrivateUpToken();
	}
}
