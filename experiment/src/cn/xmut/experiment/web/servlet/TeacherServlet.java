package cn.xmut.experiment.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.domain.Teacher;
import cn.xmut.experiment.service.IAppraisalService;
import cn.xmut.experiment.service.IDeptService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.IOpenTimeService;
import cn.xmut.experiment.service.impl.AppraisalServiceImpl;
import cn.xmut.experiment.service.impl.DeptServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;
import cn.xmut.experiment.service.impl.OpenTimeServiceImpl;

public class TeacherServlet extends BaseServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	//查看项目详细信息
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String experimentId = request.getParameter("experimentId");
		IExperimentService experimentService = new ExperimentServiceImpl();
		Experiment experiment = experimentService.getExperiment(Integer.parseInt(experimentId));
		IAppraisalService appraisalService = new AppraisalServiceImpl();
		List<String> opinionList = appraisalService.getOpinionList(Integer.parseInt(experimentId));
		request.setAttribute("opinionList", opinionList);
		request.setAttribute("experiment", experiment);
		request.setAttribute("userType", "teacher");
		request.getRequestDispatcher("/WEB-INF/page/common/detail.jsp").forward(request, response);
	}
	
	//查看已通过实验项目
	public void viewpass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/page/teacher/viewpass.jsp").forward(request, response);
	}
	//查看个人信息
	public void myInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		IDeptService deptService = new DeptServiceImpl();
		String deptName = deptService.getDeptName(teacher.getDeptId());
		teacher.setDeptName(deptName);
		request.getRequestDispatcher("/WEB-INF/page/teacher/myInfo.jsp").forward(request, response);
	}
	
	
}
