package com.bingoogol.algorithm.web.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bingoogol.algorithm.dto.Json;
import com.bingoogol.algorithm.dto.QuestionDto;
import com.bingoogol.algorithm.model.Channel;
import com.bingoogol.algorithm.model.Question;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.service.IChannelService;
import com.bingoogol.algorithm.service.IQuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IQuestionService questionService;

	@RequestMapping(value="/front/add",method=RequestMethod.GET)
	public String frontAdd(Model model) {
		return "front/addquestion";
	}
	
	@RequestMapping(value="/front/add",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody String frontAdd(QuestionDto questionDto, HttpSession session) {
		Json json = new Json();
		Channel channel = channelService.getChannel(questionDto.getCid());
		Question question = questionDto.getQuestion();
		question.setChannel(channel);
		question.setUser((User)session.getAttribute("loginUser"));
		question.setDateCreated(new Date());
		question.setDateModified(new Date());
		questionService.addQuestion(question);
		json.setSuccess(true);
		return JSON.toJSONString(json);
	}
}
