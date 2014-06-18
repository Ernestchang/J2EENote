package cn.xmut.experiment.dao;

import java.util.List;

import cn.xmut.experiment.domain.Specialty;

public interface ISpecialtyDao {
	/**
	 * 根据系号获取该系所有专业信息
	 * @param deptId 系号
	 * @return 专业集合
	 */
	public abstract List<Specialty> getSpecialtyList(int deptId);
}
