package cn.xmut.experiment.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.service.IAppraisalService;
import cn.xmut.experiment.service.IDeptService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.impl.AppraisalServiceImpl;
import cn.xmut.experiment.service.impl.DeptServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;

public class DistributeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	//跳转到分发项目页面
	public void goDistributeUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String experimentId = request.getParameter("experimentId");
		IExperimentService experimentService = new ExperimentServiceImpl();
		Experiment experiment = experimentService.getExperiment(Integer.parseInt(experimentId));
		request.setAttribute("experiment", experiment);
		if("success".equals(request.getParameter("information"))) {
			request.setAttribute("information", "分发成功");
		} else if("error".equals(request.getParameter("information"))) {
			request.setAttribute("information", "分发失败");
		} else {
			IDeptService deptService = new DeptServiceImpl();
			List<Dept> deptList = deptService.getDeptList();
			request.setAttribute("deptList", deptList);
		}
		request.getRequestDispatcher("/WEB-INF/page/manager/distribute.jsp").forward(request, response);
	}
	//分发项目
	public void distribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String experimentId = request.getParameter("experimentId");
		System.out.println("experimentId:" + experimentId);
		String[] expertIds = request.getParameterValues("expertId");
		IAppraisalService appraisalService = new AppraisalServiceImpl();
		if(appraisalService.addAppraisal(Integer.parseInt(experimentId), expertIds)) {
			response.sendRedirect("DistributeServlet?cmd=goDistributeUI&information=success&experimentId=" + experimentId);
		} else {
			response.sendRedirect("DistributeServlet?cmd=goDistributeUI&information=error&experimentId=" + experimentId);
		}
	}
}
