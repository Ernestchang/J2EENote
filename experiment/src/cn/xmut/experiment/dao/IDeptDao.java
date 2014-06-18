package cn.xmut.experiment.dao;

import java.util.List;

import cn.xmut.experiment.domain.Dept;

public interface IDeptDao {
    /**
     * 根据部门号获取部门名称
     * @param deptId 部门号
     * @return 部门名称
     */
	public abstract String getDeptName(int deptId);
	/**
	 * 获取所有部门
	 * @return 部门集合
	 */
	public abstract List<Dept> getDeptList();
}
