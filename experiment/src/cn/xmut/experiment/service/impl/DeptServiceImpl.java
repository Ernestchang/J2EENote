package cn.xmut.experiment.service.impl;

import java.util.List;

import cn.xmut.experiment.dao.IDeptDao;
import cn.xmut.experiment.dao.impl.jdbc.DeptDaoImpl;
import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.service.IDeptService;

public class DeptServiceImpl implements IDeptService {
	private IDeptDao deptDao = new DeptDaoImpl();

	public String getDeptName(int deptId) {
		return deptDao.getDeptName(deptId);
	}

	public List<Dept> getDeptList() {
		return deptDao.getDeptList();
	}


}
