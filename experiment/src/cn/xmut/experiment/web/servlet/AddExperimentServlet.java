package cn.xmut.experiment.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.IOFileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.domain.Teacher;
import cn.xmut.experiment.service.IDeptService;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.IOpenTimeService;
import cn.xmut.experiment.service.impl.DeptServiceImpl;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;
import cn.xmut.experiment.service.impl.OpenTimeServiceImpl;
import cn.xmut.experiment.util.CodingUtils;

public class AddExperimentServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private static final int MAX_SIZE = 2*1024*1024;

	//跳转到添加项目页面
	public void goAddUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOpenTimeService openTimeService = new OpenTimeServiceImpl();
		IDeptService deptService = new DeptServiceImpl();
		List<OpenTime> openTimeList = openTimeService.getOpenTimeList();
		List<Dept> deptList = deptService.getDeptList();
		request.setAttribute("openTimeList", openTimeList);
		request.setAttribute("deptList", deptList);
		if("success".equals(request.getParameter("information"))) {
			request.setAttribute("information", "添加成功");
		} else if("error".equals(request.getParameter("information"))) {
			request.setAttribute("information", "添加失败");
		} else if("error2".equals(request.getParameter("information"))) {
			request.setAttribute("information", "上传文档过大");
		}
		request.getRequestDispatcher("/WEB-INF/page/headman/add.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void addExperiment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			FileItemFactory  factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(MAX_SIZE);
			upload.setHeaderEncoding("ISO-8859-1");
			try {
				List items  = null;
				try {
					items = upload.parseRequest(request);
				} catch (SizeLimitExceededException e1) {
					response.sendRedirect("AddExperimentServlet?cmd=goAddUI&information=error2");
					return;
				} catch(IOFileUploadException e2) {
					System.out.println("用户断开连接");
					return;
				}
				Experiment experiment = new Experiment();
				OpenTime openTime = new OpenTime();
				Iterator iter = items.iterator();
				FileItem fileItem = null;
				String docName = null;
				String deptName = null;
				String courseName = null;
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
				    String name = item.getFieldName();
					if (!item.isFormField()) {
						if("docPath".equals(name)) {
							String value = item.getName();
							value = CodingUtils.iso2utf(value);
							docName = value.substring(value.lastIndexOf("\\") + 1);
							fileItem = item;
						}
				    } else {
				    	String value = item.getString("utf-8");
				    	if("courseId".equals(name)) {
				    		experiment.setCourseId(Integer.parseInt(value));
				    	} else if("experimentName".equals(name)) {
				    		experiment.setExperimentName(value);
				    	}else if("specialtyId".equals(name)) {
				    		experiment.setSpecialtyId(Integer.parseInt(value));
				    	} else if("experimentDemand".equals(name)) {
				    		experiment.setExperimentDemand(value);
						} else if("schoolYear".equals(name)) {
							openTime.setSchoolYear(value);
						} else if("schoolTerm".equals(name)) {
							openTime.setSchoolTerm(Integer.parseInt(value));
				    	}else if("experimentCategory".equals(name)) {
				    		experiment.setExperimentCategory(value);
				    	} else if("creditHours".equals(name)) {
				    		experiment.setCreditHours(Integer.parseInt(value));
						} else if("introduction".equals(name)) {
							experiment.setIntroduction(value);
						} else if("experimentType".equals(name)) {
							experiment.setExperimentType(value);
						} else if("deptName".equals(name)) {
							deptName = value;
						} else if("courseName".equals(name)) {
							courseName = value;
						}
				    }
				}
				IOpenTimeService openTimeService = new OpenTimeServiceImpl();
				openTimeService.getOpenTimeId(openTime);
				experiment.setOpenTimeId(openTime.getOpenTimeId());
				Teacher teacher = (Teacher)request.getSession().getAttribute("user");
				String teacherId = teacher.getTeacherId();
				experiment.setTeacherId(teacherId);
				String dirPath = request.getSession().getServletContext().getRealPath("/项目文档/" + deptName + "/" + openTime.getSchoolYear() + "学年第" + openTime.getSchoolTerm() + "学期/" + courseName);
				IExperimentService experimentService = new ExperimentServiceImpl();
				if(experimentService.addExperiment(experiment, docName, dirPath, fileItem)) {
					response.sendRedirect("AddExperimentServlet?cmd=goAddUI&information=success");
				} else {
					response.sendRedirect("AddExperimentServlet?cmd=goAddUI&information=error");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		
	}

}
