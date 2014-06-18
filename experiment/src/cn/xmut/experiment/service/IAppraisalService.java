package cn.xmut.experiment.service;

import java.util.List;

import cn.xmut.experiment.domain.Appraisal;

public interface IAppraisalService {
	/**
	 * 工作人员分发实验项目，向评审信息表中插入数据
	 * @param experimentId 实验项目编号
	 * @param expertIds 包含了三位评审专家编号的数组
	 * @return 是否添加成功
	 */
	public abstract boolean addAppraisal(int experimentId,String[] expertIds);
	/**
	 * 某一位专家评审后，修改评审信息
	 * @param appraisal
	 * @return 是否修改成功
	 */
	public abstract boolean updateAppraisal(Appraisal appraisal);
	/**
	 * 获取指定实验编号实验的所有信息（管理员评审）
	 * @param experimentId 实验编号
	 * @return 评审信息列表
	 */
	public abstract List<Appraisal> getAppraisalList(int experimentId);
	/**
	 * 获取指定实验编号实验的所有评审意见（查看项目详情）
	 * @param experimentId 实验编号
	 * @return 包含了评审意见集合
	 */
	public abstract List<String> getOpinionList(int experimentId);
}
