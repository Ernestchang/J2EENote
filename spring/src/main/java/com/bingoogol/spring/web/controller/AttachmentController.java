package com.bingoogol.spring.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingoogol.spring.service.AttachmentService;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {
	@Resource
	private AttachmentService attachmentService;

}