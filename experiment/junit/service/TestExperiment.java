package service;

import org.junit.Test;

import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.service.IExperimentService;
import cn.xmut.experiment.service.impl.ExperimentServiceImpl;

public class TestExperiment {
	IExperimentService experimentService = new ExperimentServiceImpl();
	@Test
	public void getExperiment() {
		Experiment experiment = experimentService.getExperiment(12);
		System.out.println(experiment.getCourseName());
		System.out.println(experiment.getExperimentName());
		System.out.println(experiment.getExperimentCategory());
	}
	@Test
	public void getDocPath() {
		String docPath = experimentService.getDocPath(4);
		System.out.println("docPath:" + docPath);
	}
	@Test
	public void del() {
		Experiment experiment = new Experiment();
		experiment.setExperimentId(2);
		experiment.setDocPath("D:\\Tomcat 6.0\\webapps\\experiment\\项目文档\\2012-2013\\测试文档4.doc");
//		File file = new File("D:\\Tomcat 6.0\\webapps\\experiment\\项目文档\\2012-2013\\测试文档4.doc");
//		if(file.isFile()) {
//			System.out.println("isfile");
//			if(file.exists()) {
//				System.out.println("exist");
//				if(file.delete()) {
//					System.out.println("success");
//				}
//			}
//		}
		System.out.println(experimentService.delExperiment(experiment));
	}
}
