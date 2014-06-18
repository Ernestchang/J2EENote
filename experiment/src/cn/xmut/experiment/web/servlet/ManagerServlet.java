package cn.xmut.experiment.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.xmut.experiment.domain.Course;
import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.Manager;
import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.domain.ShowExperiment;
import cn.xmut.experiment.domain.ShowExpert;
import cn.xmut.experiment.service.IAppraisalService;
import cn.xmut.experiment.service.ICourseService;
import cn.xmut.experiment.service.IDeptService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.IExpertService;
import cn.xmut.experiment.service.IOpenTimeService;
import cn.xmut.experiment.service.impl.AppraisalServiceImpl;
import cn.xmut.experiment.service.impl.CourseServiceImpl;
import cn.xmut.experiment.service.impl.DeptServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;
import cn.xmut.experiment.service.impl.ExpertServiceImpl;
import cn.xmut.experiment.service.impl.OpenTimeServiceImpl;

public class ManagerServlet extends BaseServlet {

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
		request.setAttribute("userType", "manager");
		request.getRequestDispatcher("/WEB-INF/page/common/detail.jsp").forward(request, response);
	}
	
	//跳转到查看分发项目列表页面
	public void goNodistributelistUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager manager = (Manager) request.getSession().getAttribute("user");
		int deptId = manager.getDeptId();
		ICourseService courseService = new CourseServiceImpl();
		List<Course> courseList = courseService.getCourseListByDeptId(deptId);
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("/WEB-INF/page/manager/nodistributelist.jsp").forward(request, response);
	}
	//获取未分发项目列表
	public void queryNodistribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String schoolYear = request.getParameter("schoolYear");
		String schoolTerm = request.getParameter("schoolTerm");
		String courseId = request.getParameter("courseId");
		Experiment experiment = new Experiment();
		experiment.setSchoolYear(schoolYear);
		experiment.setSchoolTerm(Integer.parseInt(schoolTerm));
		experiment.setCourseId(Integer.parseInt(courseId));
		IExperimentService experimentService = new ExperimentServiceImpl();
		List<ShowExperiment> list = experimentService.queryNodistribute(experiment);
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.print(jsonArray.toString());
	}
	//获取专家列表
	public void getExpertJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String specialtyId = request.getParameter("specialtyId");
		IExpertService expertService = new ExpertServiceImpl();
		List<ShowExpert> list = expertService.getExpertList(Integer.parseInt(specialtyId));
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.print(jsonArray.toString());
	}
	//跳转到查看未审核项目列表页面
	public void goNoEstimatelistUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager manager = (Manager) request.getSession().getAttribute("user");
		int deptId = manager.getDeptId();
		ICourseService courseService = new CourseServiceImpl();
		List<Course> courseList = courseService.getCourseListByDeptId(deptId);
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("/WEB-INF/page/manager/noestimatelist.jsp").forward(request, response);
	}
	//获取未审核项目列表
	public void queryNoEstimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String schoolYear = request.getParameter("schoolYear");
		String schoolTerm = request.getParameter("schoolTerm");
		String courseId = request.getParameter("courseId");
		Experiment experiment = new Experiment();
		experiment.setSchoolYear(schoolYear);
		experiment.setSchoolTerm(Integer.parseInt(schoolTerm));
		experiment.setCourseId(Integer.parseInt(courseId));
		IExperimentService experimentService = new ExperimentServiceImpl();
		List<ShowExperiment> list = experimentService.managerQueryNoExtimate(experiment);
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.print(jsonArray.toString());
	}
	
	//跳转到已通过实验项目页面
	public void viewpass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/page/manager/viewpass.jsp").forward(request, response);
	}
	//跳转到未通过实验项目页面
	public void viewnopass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager manager = (Manager) request.getSession().getAttribute("user");
		int deptId = manager.getDeptId();
		ICourseService courseService = new CourseServiceImpl();
		List<Course> courseList = courseService.getCourseListByDeptId(deptId);
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("/WEB-INF/page/manager/viewnopass.jsp").forward(request, response);
	}
	//获取未通过实验项目列表
	public void queryNoPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String schoolYear = request.getParameter("schoolYear");
		String schoolTerm = request.getParameter("schoolTerm");
		String courseId = request.getParameter("courseId");
		Experiment experiment = new Experiment();
		experiment.setSchoolYear(schoolYear);
		experiment.setSchoolTerm(Integer.parseInt(schoolTerm));
		experiment.setCourseId(Integer.parseInt(courseId));
		IExperimentService experimentService = new ExperimentServiceImpl();
		List<ShowExperiment> list = experimentService.managerQueryNoPass(experiment);
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.print(jsonArray.toString());
	}
	//删除实验
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String experimentIds = request.getParameter("experimentId");
		int experimentId = Integer.parseInt(experimentIds);
		IExperimentService experimentService = new ExperimentServiceImpl();
		String docPath = experimentService.getDocPath(experimentId);
		Experiment experiment = new Experiment();
		experiment.setExperimentId(experimentId);
		experiment.setDocPath(docPath);
		if(experimentService.delExperiment(experiment)) {
			out.print("success");
		} else {
			out.print("error");
		}
	}
	

	
}
