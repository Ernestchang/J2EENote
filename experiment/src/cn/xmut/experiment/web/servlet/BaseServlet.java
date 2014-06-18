package cn.xmut.experiment.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.xmut.experiment.domain.Course;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.ShowExperiment;
import cn.xmut.experiment.domain.Specialty;
import cn.xmut.experiment.service.ICourseService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.ISpecialtyService;
import cn.xmut.experiment.service.impl.CourseServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;
import cn.xmut.experiment.service.impl.SpecialtyServiceImpl;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		try {
			Method method = this.getClass().getMethod(cmd, HttpServletRequest.class, HttpServletResponse.class);
			if(method == null) {
				throw new ServletException("方法没有找到1");
			} else {
				method.invoke(this, request, response);
			}
		} catch (Exception e) {
			System.out.println("方法没找到");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	//根据系号获取课程信息
	public void getCourseJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String deptId = request.getParameter("deptId");
		ICourseService courseService = new CourseServiceImpl();
		List<Course> list = courseService.getCourseListByDeptId(Integer.parseInt(deptId));
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"deptId"});
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		out.print(jsonArray.toString());
	}
	//根据系号获取专业信息
	public void getSpecialtyJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String deptId = request.getParameter("deptId");
		ISpecialtyService specialtyService = new SpecialtyServiceImpl();
		List<Specialty> list = specialtyService.getSpecialtyList(Integer.parseInt(deptId));
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"deptId"});
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		out.print(jsonArray.toString());
	}
	
	//查询已通过实验项目
	public void queryPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String schoolYear = request.getParameter("schoolYear");
		String schoolTerm = request.getParameter("schoolTerm");
		String courseId = request.getParameter("courseId");
		Experiment experiment = new Experiment();
		experiment.setSchoolYear(schoolYear);
		experiment.setSchoolTerm(Integer.parseInt(schoolTerm));
		experiment.setCourseId(Integer.parseInt(courseId));
		IExperimentService experimentService = new ExperimentServiceImpl();
		List<ShowExperiment> list = experimentService.queryPass(experiment);
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.print(jsonArray.toString());
	}

}
