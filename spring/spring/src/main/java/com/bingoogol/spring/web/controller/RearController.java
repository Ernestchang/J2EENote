package com.bingoogol.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rear")
public class RearController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "rear/index";
	}
	
}
