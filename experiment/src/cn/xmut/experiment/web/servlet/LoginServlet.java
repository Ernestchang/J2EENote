package cn.xmut.experiment.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xmut.experiment.domain.Expert;
import cn.xmut.experiment.domain.Manager;
import cn.xmut.experiment.domain.Teacher;
import cn.xmut.experiment.service.impl.ExpertServiceImpl;
import cn.xmut.experiment.service.impl.ManagerServiceImpl;
import cn.xmut.experiment.service.impl.TeacherServiceImpl;
import cn.xmut.experiment.util.MyTools;

public class LoginServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private String userid = null;
	private String password = null;
	//处理课程组长登陆
	public void kczz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userid = request.getParameter("userid");
		password = request.getParameter("password");
		Teacher teacher = new Teacher(userid,MyTools.getMD5(password),"课程组长");
		TeacherServiceImpl teacherService = new TeacherServiceImpl();
		if(teacherService.isTeacher(teacher)) {
			request.getSession().setAttribute("user", teacher);
			request.getRequestDispatcher("/HeadmanServlet?cmd=viewnopass").forward(request, response);
		} else {
			this.error(request, response);
		}
	}
	//处理实验老师登陆
	public void syls(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userid = request.getParameter("userid");
		password = request.getParameter("password");
		Teacher teacher = new Teacher(userid,MyTools.getMD5(password),"实验老师");
		TeacherServiceImpl teacherService = new TeacherServiceImpl();
		if(teacherService.isTeacher(teacher)) {
			request.getSession().setAttribute("user", teacher);
			request.getRequestDispatcher("/TeacherServlet?cmd=viewpass").forward(request, response);
		} else {
			this.error(request, response);
		}
	}
	//处理评审专家登陆
	public void pszj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userid = request.getParameter("userid");
		password = request.getParameter("password");
		Expert expert = new Expert(userid, MyTools.getMD5(password));
		ExpertServiceImpl expertService = new ExpertServiceImpl();
		if(expertService.isExpert(expert)) {
			request.getSession().setAttribute("user", expert);
			request.getRequestDispatcher("/ExpertServlet?cmd=noestimatelist").forward(request, response);
		} else {
			this.error(request, response);
		}
	}
	//处理管理员登陆
	public void gzry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userid = request.getParameter("userid");
		password = request.getParameter("password");
		Manager manager = new Manager(userid,MyTools.getMD5(password));
		ManagerServiceImpl managerService = new ManagerServiceImpl();
		if(managerService.isManager(manager)) {
			request.getSession().setAttribute("user", manager);
			request.getRequestDispatcher("/ManagerServlet?cmd=goNodistributelistUI").forward(request, response);
		} else {
			this.error(request, response);
		}
	}
	
	//安全退出
	public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	//登陆失败，返回登陆页面
	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("information", "用户名或密码错误");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	

}
