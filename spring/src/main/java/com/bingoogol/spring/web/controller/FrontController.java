package com.bingoogol.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/front")
public class FrontController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "front/index";
	}

}
