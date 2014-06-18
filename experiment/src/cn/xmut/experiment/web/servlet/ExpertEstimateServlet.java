package cn.xmut.experiment.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xmut.experiment.domain.Appraisal;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.Expert;
import cn.xmut.experiment.service.IAppraisalService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.impl.AppraisalServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;



public class ExpertEstimateServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	//跳转到评审页面
	public void goEstimateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String experimentId = request.getParameter("experimentId");
		IExperimentService experimentService = new ExperimentServiceImpl();
		Experiment experiment = experimentService.getExperiment(Integer.parseInt(experimentId));
		request.setAttribute("experiment", experiment);
		if("success".equals(request.getParameter("information"))) {
			request.setAttribute("information", "评审成功");
		} else if("error".equals(request.getParameter("information"))) {
			request.setAttribute("information", "评审失败");
		}
		request.getRequestDispatcher("/WEB-INF/page/expert/estimate.jsp").forward(request, response);
	}
	//评审项目
	public void estimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Expert expert = (Expert) request.getSession().getAttribute("user");
		String expertId = expert.getExpertId();
		String experimentId = request.getParameter("experimentId");
		String appraisalStatus = request.getParameter("appraisalStatus");
		String experimentType = request.getParameter("experimentType");
		String opinion = request.getParameter("opinion");
		Appraisal appraisal = new Appraisal();
		appraisal.setExperimentId(Integer.parseInt(experimentId));
		appraisal.setExpertId(expertId);
		appraisal.setAppraisalStatus(appraisalStatus);
		appraisal.setExperimentType(experimentType);
		appraisal.setOpinion(opinion);
		IAppraisalService appraisalService = new AppraisalServiceImpl();
		if(appraisalService.updateAppraisal(appraisal)) {
			response.sendRedirect("ExpertEstimateServlet?cmd=goEstimateUI&information=success&experimentId=" + experimentId);
		} else {
			response.sendRedirect("ExpertEstimateServlet?cmd=goEstimateUI&information=error&experimentId=" + experimentId);
		}
	}
}
