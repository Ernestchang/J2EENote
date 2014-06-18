package cn.xmut.experiment.service.impl;

import java.util.List;

import cn.xmut.experiment.dao.IAppraisalDao;
import cn.xmut.experiment.dao.impl.jdbc.AppraisalDaoImpl;
import cn.xmut.experiment.domain.Appraisal;
import cn.xmut.experiment.service.IAppraisalService;

public class AppraisalServiceImpl implements IAppraisalService {
	IAppraisalDao appraisalDao = new AppraisalDaoImpl();
	public boolean addAppraisal(int experimentId, String[] expertIds) {
		return appraisalDao.addAppraisal(experimentId, expertIds);
	}
	public List<Appraisal> getAppraisalList(int experimentId) {
		return appraisalDao.getAppraisalList(experimentId);
	}
	public boolean updateAppraisal(Appraisal appraisal) {
		return appraisalDao.updateAppraisal(appraisal);
	}
	public List<String> getOpinionList(int experimentId) {
		return appraisalDao.getOpinionList(experimentId);
	}

}
