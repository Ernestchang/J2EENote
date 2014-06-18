package cn.xmut.experiment.service.impl;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cn.xmut.experiment.dao.IExperimentDao;
import cn.xmut.experiment.dao.impl.jdbc.ExperimentDaoImpl;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.ShowExperiment;
import cn.xmut.experiment.service.IExperimentService;

public class ExperimentServiceImpl implements IExperimentService {
	IExperimentDao experimentDao = new ExperimentDaoImpl();
	
	public boolean addExperiment(Experiment experiment, String docName,String dirPath, FileItem fileItem) {
		return experimentDao.addExperiment(experiment, docName, dirPath, fileItem);
	}

	public boolean updateExperiment(Experiment experiment) {
		return experimentDao.updateExperiment(experiment);
	}

	public String getDocPath(int experimentId) {
		return experimentDao.getDocPath(experimentId);
	}

	public Experiment getExperiment(int experimentId) {
		return experimentDao.getExperiment(experimentId);
	}

	public List<ShowExperiment> queryPass(Experiment experiment) {
		return experimentDao.queryPass(experiment);
	}

	public List<ShowExperiment> queryNodistribute(Experiment experiment) {
		return experimentDao.queryNodistribute(experiment);
	}

	public List<ShowExperiment> expertQueryNoExtimate(Experiment experiment, String expertId) {
		return experimentDao.expertQueryNoExtimate(experiment, expertId);
	}

	public List<ShowExperiment> managerQueryNoExtimate(Experiment experiment) {
		return experimentDao.managerQueryNoExtimate(experiment);
	}

	public List<ShowExperiment> managerQueryNoPass(Experiment experiment) {
		return experimentDao.managerQueryNoPass(experiment);
	}

	public boolean delExperiment(Experiment experiment) {
		return experimentDao.delExperiment(experiment);
	}

	public List<ShowExperiment> headmanQueryNoPass(Experiment experiment) {
		return experimentDao.headmanQueryNoPass(experiment);
	}

}
