package cn.xmut.experiment.service.impl;

import cn.xmut.experiment.dao.IManagerDao;
import cn.xmut.experiment.dao.impl.jdbc.MangerDaoImpl;
import cn.xmut.experiment.domain.Manager;
import cn.xmut.experiment.service.IManagerService;

public class ManagerServiceImpl implements IManagerService {
	private IManagerDao managerDao = new MangerDaoImpl();
	public boolean isManager(Manager manager) {
		return managerDao.isManager(manager);
	}
	
}
