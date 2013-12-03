package com.bingoogol.algorithm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.service.IAlgorithmService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private IAlgorithmService algorithmService;
	@RequestMapping("/front")
	public String index(Pager pager, Model model) {
		model.addAttribute("pagerJson",algorithmService.find(pager,null, null));
		return "front/home";
	}

}
