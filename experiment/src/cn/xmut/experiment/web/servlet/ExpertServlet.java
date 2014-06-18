package cn.xmut.experiment.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.Expert;
import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.domain.ShowExperiment;
import cn.xmut.experiment.service.IAppraisalService;
import cn.xmut.experiment.service.IDeptService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.IOpenTimeService;
import cn.xmut.experiment.service.impl.AppraisalServiceImpl;
import cn.xmut.experiment.service.impl.DeptServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;
import cn.xmut.experiment.service.impl.OpenTimeServiceImpl;



public class ExpertServlet extends BaseServlet {

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
		request.setAttribute("userType", "expert");
		request.getRequestDispatcher("/WEB-INF/page/common/detail.jsp").forward(request, response);
	}
	//查看实验项目
	public void viewpass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/page/expert/viewpass.jsp").forward(request, response);
	}
	//跳转到查看未评审列表页面
	public void noestimatelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/page/expert/noestimatelist.jsp").forward(request, response);
	}
	//查询未评审实验项目
	public void queryNoExtimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Expert expert = (Expert) request.getSession().getAttribute("user");
		String expertId = expert.getExpertId();
		PrintWriter out = response.getWriter();
		String schoolYear = request.getParameter("schoolYear");
		String schoolTerm = request.getParameter("schoolTerm");
		String courseId = request.getParameter("courseId");
		Experiment experiment = new Experiment();
		experiment.setSchoolYear(schoolYear);
		experiment.setSchoolTerm(Integer.parseInt(schoolTerm));
		experiment.setCourseId(Integer.parseInt(courseId));
		IExperimentService experimentService = new ExperimentServiceImpl();
		List<ShowExperiment> list = experimentService.expertQueryNoExtimate(experiment, expertId);
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.print(jsonArray.toString());
	}
	//查看已评审项目
	public void estimatelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/page/expert/estimatelist.jsp").forward(request, response);
	}
	
}
