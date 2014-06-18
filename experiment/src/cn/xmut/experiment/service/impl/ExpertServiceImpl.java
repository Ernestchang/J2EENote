package cn.xmut.experiment.service.impl;

import java.util.List;

import cn.xmut.experiment.dao.IExpertDao;
import cn.xmut.experiment.dao.impl.jdbc.ExpertDaoImpl;
import cn.xmut.experiment.domain.Expert;
import cn.xmut.experiment.domain.ShowExpert;
import cn.xmut.experiment.service.IExpertService;

public class ExpertServiceImpl implements IExpertService {
	private IExpertDao expertDao = new ExpertDaoImpl();
	
	public boolean isExpert(Expert expert) {
		return expertDao.isExpert(expert);
	}

	public List<ShowExpert> getExpertList(int specialtyId) {
		return expertDao.getExpertList(specialtyId);
	}

}
