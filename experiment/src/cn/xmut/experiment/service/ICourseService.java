package cn.xmut.experiment.service;

import java.util.List;

import cn.xmut.experiment.domain.Course;

public interface ICourseService {
	/**
	 * 根据系号获取该系的所有课程信息
	 * @param deptId 系号
	 * @return 课程集合
	 */
	public abstract List<Course> getCourseListByDeptId(int deptId);
}
