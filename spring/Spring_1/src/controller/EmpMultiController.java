package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import bean.Emp;

public class EmpMultiController extends MultiActionController {
	
	public ModelAndView to_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add_emp");
		mav.addObject("deptList", new String[]{"sales","manage"});
		return mav;
	}
	//当有httpsession时，httpsession必须放在commond之前
	public String add_emp(HttpServletRequest request, HttpServletResponse response, Emp emp) {
		System.out.println(emp);
		return "success";
	}
}
