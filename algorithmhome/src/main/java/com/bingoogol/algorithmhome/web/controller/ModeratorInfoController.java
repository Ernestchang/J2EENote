package com.bingoogol.algorithmhome.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.algorithmhome.dto.AjaxObj;
import com.bingoogol.algorithmhome.service.ModeratorInfoService;

@Controller
@RequestMapping("/moderatorinfo")
public class ModeratorInfoController {
	@Resource
	private ModeratorInfoService moderatorInfoService;
	
	@RequestMapping(value = "/admin/notvertifylist", method = RequestMethod.GET)
	public String notvertifylist(Model model, HttpSession session) {
		model.addAttribute("list", moderatorInfoService.notvertifylist());
		return "admin/moderator/notvertifylist";
	}
	
	@RequestMapping(value = "/admin/changeStatus/{id}/{status}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String changeStatus(@PathVariable String id,@PathVariable int status, HttpSession session) {
		AjaxObj ajaxObj = new AjaxObj();
		@SuppressWarnings("unchecked")
		Map<String, Object> loginUser = (Map<String, Object>) session.getAttribute("loginUser");
		String mender = (String) loginUser.get("id");
		if(moderatorInfoService.changeStatus(id,mender,status)) {
			ajaxObj.setSuccess(true);
		} else {
			ajaxObj.setSuccess(false);
		}
		return new JSONObject(ajaxObj).toString();
	}
	
}
