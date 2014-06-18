package cn.xmut.experiment.service.impl;

import java.util.List;

import cn.xmut.experiment.dao.ISpecialtyDao;
import cn.xmut.experiment.dao.impl.jdbc.SpecialtyDaoImpl;
import cn.xmut.experiment.domain.Specialty;
import cn.xmut.experiment.service.ISpecialtyService;

public class SpecialtyServiceImpl implements ISpecialtyService {
	private ISpecialtyDao specialtyDao = new SpecialtyDaoImpl();
	public List<Specialty> getSpecialtyList(int deptId) {
		return specialtyDao.getSpecialtyList(deptId);
	}

}
