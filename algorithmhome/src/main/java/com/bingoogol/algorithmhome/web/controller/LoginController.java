package com.bingoogol.algorithmhome.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.algorithmhome.dto.AjaxObj;
import com.bingoogol.algorithmhome.dto.UserLoginDto;
import com.bingoogol.algorithmhome.exception.IllegalClientException;
import com.bingoogol.algorithmhome.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "common/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String login(@Valid UserLoginDto userLoginDto, BindingResult bindingResult, HttpSession session) {
		AjaxObj ajaxObj = new AjaxObj();
		if (bindingResult.hasErrors()) {
			// 此时没有通过浏览器表单正常提交（比如通过postman提交）或者浏览器js被禁用了
			throw new IllegalClientException("请通过正确的方式提交信息");
		}
		if (!userLoginDto.getVcode().equalsIgnoreCase((String) session.getAttribute("vcode"))) {
			ajaxObj.setSuccess(false);
			ajaxObj.setMsg("验证码输入错误");
		} else {
			Map<String, Object> loginUser = userService.login(userLoginDto);
			if (loginUser != null) {
				switch ((int) loginUser.get("status")) {
				case 2:
					ajaxObj.setSuccess(false);
					ajaxObj.setMsg("对不起，您的账户已被管理员禁用");
					break;
				case 3:
					ajaxObj.setSuccess(false);
					ajaxObj.setMsg((String) loginUser.get("id"));
					ajaxObj.setObj(3);
					break;
				case 4:
					ajaxObj.setSuccess(true);
					ajaxObj.setMsg("登录成功");
					ajaxObj.setObj(loginUser.get("type"));
					session.setAttribute("loginUser", loginUser);
					break;
				}
				session.removeAttribute("vcode");
			} else {
				ajaxObj.setSuccess(false);
				ajaxObj.setMsg("用户名或密码错误");
			}
		}
		return new JSONObject(ajaxObj).toString();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("loginUser", null);
		return "redirect:/";
	}

}
