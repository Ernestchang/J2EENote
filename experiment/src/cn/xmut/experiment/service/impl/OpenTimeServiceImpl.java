package cn.xmut.experiment.service.impl;

import java.util.List;

import cn.xmut.experiment.dao.IOpenTimeDao;
import cn.xmut.experiment.dao.impl.jdbc.OpenTimeDaoImpl;
import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.service.IOpenTimeService;

public class OpenTimeServiceImpl implements IOpenTimeService {
	private IOpenTimeDao openTimeDao = new OpenTimeDaoImpl();
	public List<OpenTime> getOpenTimeList() {
		return openTimeDao.getOpenTimeList();
	}
	public void getOpenTimeId(OpenTime openTime) {
		openTimeDao.getOpenTimeId(openTime);
	}
}
