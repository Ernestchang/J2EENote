package service;

import org.junit.Test;

import cn.xmut.experiment.dao.IExpertDao;
import cn.xmut.experiment.dao.impl.jdbc.ExpertDaoImpl;
import cn.xmut.experiment.domain.Expert;

public class TestExpert {

	@Test
	public void isExpert() {
		IExpertDao expertDao = new ExpertDaoImpl();
		Expert expert = new Expert("1007092133", "e10adc3949ba59abbe56e057f20f883e");
		if(expertDao.isExpert(expert)) {
			System.out.println(expert.getExpertName());
		}
	}
}
