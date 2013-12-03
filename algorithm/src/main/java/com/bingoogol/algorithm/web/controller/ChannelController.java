package com.bingoogol.algorithm.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bingoogol.algorithm.dto.Json;
import com.bingoogol.algorithm.model.Channel;
import com.bingoogol.algorithm.service.IChannelService;

@Controller
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	private IChannelService channelService;

	@RequestMapping(value = "/getJsonByPid/{pid}",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody String getJsonByPid(@PathVariable Integer pid) {
		List<Channel> list = channelService.listChannel(pid);
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(value="/front/add",method=RequestMethod.GET)
	public String frontAdd(Model model) {
		return "front/addchannel";
	}
	
	@RequestMapping(value="/front/add",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody String frontAdd(String name, Integer pid) {
		Json json = new Json();
		Channel pchannel = channelService.getChannel(pid);
		Channel channel = new Channel();
		channel.setParent(pchannel);
		channel.setName(name);
		channel.setIsTop(false);
		channel.setStatus(1);
		channel.setDateCreated(new Date());
		channel.setDateModified(new Date());
		channelService.addChannel(channel);
		json.setSuccess(true);
		return JSON.toJSONString(json);
	}

}
