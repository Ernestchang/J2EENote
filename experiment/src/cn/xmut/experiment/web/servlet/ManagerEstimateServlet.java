package cn.xmut.experiment.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xmut.experiment.domain.Appraisal;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.service.IAppraisalService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.impl.AppraisalServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;

public class ManagerEstimateServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	//跳转到最终评审页面
	public void goEstimateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String experimentId = request.getParameter("experimentId");
		IExperimentService experimentService = new ExperimentServiceImpl();
		Experiment experiment = experimentService.getExperiment(Integer.parseInt(experimentId));
		IAppraisalService appraisalService = new AppraisalServiceImpl();
		List<Appraisal> appraisalList = appraisalService.getAppraisalList(Integer.parseInt(experimentId));
		request.setAttribute("appraisalList", appraisalList);
		request.setAttribute("experiment", experiment);
		if("success".equals(request.getParameter("information"))) {
			request.setAttribute("information", "评审成功");
		} else if("error".equals(request.getParameter("information"))) {
			request.setAttribute("information", "评审失败");
		}
		request.getRequestDispatcher("/WEB-INF/page/manager/estimate.jsp").forward(request, response);
	}
	//评审项目
	public void estimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String experimentId = request.getParameter("experimentId");
		String appraisalStatus = request.getParameter("appraisalStatus");
		String experimentType = request.getParameter("experimentType");
		Experiment experiment = new Experiment();
		experiment.setExperimentId(Integer.parseInt(experimentId));
		experiment.setAppraisalStatus(appraisalStatus);
		experiment.setExperimentType(experimentType);
		IExperimentService experimentService = new ExperimentServiceImpl();
		if(experimentService.updateExperiment(experiment)) {
			response.sendRedirect("ManagerEstimateServlet?cmd=goEstimateUI&information=success&experimentId=" + experimentId);
		} else {
			response.sendRedirect("ManagerEstimateServlet?cmd=goEstimateUI&information=error&experimentId=" + experimentId);
		}
	}
}
