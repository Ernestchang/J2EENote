package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import bean.Emp;
//只用当表单以post方式提交才会去执行onSubmit方法
@SuppressWarnings("deprecation")
public class EmpFormController extends SimpleFormController {
	@SuppressWarnings("rawtypes")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("deptList", new String[]{"sales","manage"});
		return model;
	}
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Emp emp = (Emp) command;
		System.out.println(emp);
		return new ModelAndView(getSuccessView());
	}
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
}
