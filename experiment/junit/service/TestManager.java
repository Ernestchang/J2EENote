package service;

import org.junit.Test;

import cn.xmut.experiment.dao.IManagerDao;
import cn.xmut.experiment.dao.impl.jdbc.MangerDaoImpl;
import cn.xmut.experiment.domain.Manager;

public class TestManager {

	@Test
	public void isManager() {
		IManagerDao managerDao = new MangerDaoImpl();
		Manager manager = new Manager("1111111111", "e10adc3949ba59abbe56e057f20f883e");
		if(managerDao.isManager(manager)) {
			System.out.println(manager.getManagerName());
			System.out.println(manager.getDeptId());
		}
	}
	@Test
	public void distributeExperiment() {
//		IExperimentService experimentService = new ExperimentServiceImpl();
//		String experimentId = "4";
//		String expertIds[] = {"2222222221","2222222222","2222222223"};
//		boolean b = experimentService.distributeExperiment(experimentId, expertIds);
//		if(b) {
//			System.out.println("分发成功");
//		} else {
//			System.out.println("分发失败");
//		}
	}
}
