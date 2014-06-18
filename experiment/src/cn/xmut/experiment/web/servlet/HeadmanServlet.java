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
import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.domain.ShowExperiment;
import cn.xmut.experiment.domain.Teacher;
import cn.xmut.experiment.service.IAppraisalService;
import cn.xmut.experiment.service.IDeptService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.IOpenTimeService;
import cn.xmut.experiment.service.impl.AppraisalServiceImpl;
import cn.xmut.experiment.service.impl.DeptServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;
import cn.xmut.experiment.service.impl.OpenTimeServiceImpl;

public class HeadmanServlet extends BaseServlet {

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
		request.setAttribute("userType", "headman");
		request.getRequestDispatcher("/WEB-INF/page/common/detail.jsp").forward(request, response);
	}
	//查看已通过实验项目列表
	public void viewpass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/page/headman/viewpass.jsp").forward(request, response);
	}
	//跳转到未通过实验项目页面
	public void viewnopass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/page/headman/viewnopass.jsp").forward(request, response);
	}
	//获取未通过实验项目列表
	public void queryNoPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String schoolYear = request.getParameter("schoolYear");
		String schoolTerm = request.getParameter("schoolTerm");
		String courseId = request.getParameter("courseId");
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		Experiment experiment = new Experiment();
		experiment.setTeacherId(teacher.getTeacherId());
		experiment.setSchoolYear(schoolYear);
		experiment.setSchoolTerm(Integer.parseInt(schoolTerm));
		experiment.setCourseId(Integer.parseInt(courseId));
		IExperimentService experimentService = new ExperimentServiceImpl();
		List<ShowExperiment> list = experimentService.headmanQueryNoPass(experiment);
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
