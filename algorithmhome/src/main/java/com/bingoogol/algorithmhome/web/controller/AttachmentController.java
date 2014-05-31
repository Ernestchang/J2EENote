package com.bingoogol.algorithmhome.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingoogol.algorithmhome.service.AttachmentService;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {
	@Resource
	private AttachmentService attachmentService;

}