package cn.xmut.experiment.service;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.ShowExperiment;

public interface IExperimentService {
	/**
	 * 添加实验项目
	 * @param experiment 实验项目对象
	 * @param docName 文档名称
	 * @param dirPath 文档路径
	 * @param fileItem 文档
	 * @return 是否添加成功
	 */
	public abstract boolean addExperiment(Experiment experiment,String docName, String dirPath, FileItem fileItem);
	/**
	 * 管理员评审实验项目，修改评审状态
	 * @param experiment 实验项目对象
	 * @return 是否修改成功
	 */
	public abstract boolean updateExperiment(Experiment experiment);
	/**
	 * 根据实验项目编号获取文档存放路径
	 * @param experimentId 实验项目编号
	 * @return 文档路径
	 */
	public abstract String getDocPath(int experimentId);
	/**
	 * 根据实验项目编号获取实验项目(详情，分发时用)
	 * @param experimentId 实验项目编号
	 * @return 实验项目对象
	 */
	public abstract Experiment getExperiment(int experimentId);
	/**
	 * 实验老师查看项目列表
	 * @param experiment 实验项目对象
	 * @return 要显示的实验对象集合
	 */
	public abstract List<ShowExperiment> queryPass(Experiment experiment);
	/**
	 * 管理员查看为分发实验项目
	 * @param experiment 实验项目对象
	 * @return 要显示的实验对象集合
	 */
	public abstract List<ShowExperiment> queryNodistribute(Experiment experiment);
	/**
	 * 评审专家查看未评审实验项目
	 * @param experiment 实验项目对象
	 * @param expertId 评审专家编号
	 * @return 要显示的实验对象集合
	 */
	public abstract List<ShowExperiment> expertQueryNoExtimate(Experiment experiment, String expertId);
	/**
	 * 管理员查询未评审实验项目
	 * @param experiment 实验项目对象
	 * @return 要显示的实验对象集合
	 */
	public abstract List<ShowExperiment> managerQueryNoExtimate(Experiment experiment);
	/**
	 * 管理员查询通过实验项目
	 * @param experiment 实验项目对象
	 * @return 要显示的实验对象集合
	 */
	public abstract List<ShowExperiment> managerQueryNoPass(Experiment experiment);
	/**
	 * 根据实验项目编号和文档路径删除实验
	 * @param experiment 实验项目对象
	 * @return 是否删除成功
	 */
	public abstract boolean delExperiment(Experiment experiment);
	/**
	 * 课程组长查询通过实验项目
	 * @param experiment 实验项目对象
	 * @return 要显示的实验对象集合
	 */
	public abstract List<ShowExperiment> headmanQueryNoPass(Experiment experiment);
}
