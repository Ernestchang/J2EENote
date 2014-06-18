package cn.xmut.experiment.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;
import cn.xmut.experiment.util.CodingUtils;

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("User-Agent======"+request.getHeader("User-Agent").toLowerCase());
		String experimentId = request.getParameter("experimentId");
		IExperimentService experimentService = new ExperimentServiceImpl();
		String docPath = experimentService.getDocPath(Integer.parseInt(experimentId));
		File file = new File(docPath);
		if(file.exists()) {
			String docName = docPath.substring(docPath.lastIndexOf("\\") + 1);
			if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
				docName = CodingUtils.utf2iso(docName);
			} else {
				docName = CodingUtils.urlEncoder2utf(docName);
			}
			response.setHeader("Content-Type", "application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + docName);
			InputStream is = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len = is.read(buffer)) != -1) {
				os.write(buffer,0,len);
			}
			is.close();
			os.close();
		} else {
			System.out.println("文件不存在");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
