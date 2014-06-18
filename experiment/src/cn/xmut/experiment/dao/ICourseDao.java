package cn.xmut.experiment.dao;

import java.util.List;

import cn.xmut.experiment.domain.Course;

public interface ICourseDao {
	/**
	 * 根据系号获取该系的所有课程信息
	 * @param deptId 系号
	 * @return 课程集合
	 */
	public abstract List<Course> getCourseListByDeptId(int deptId);
}
