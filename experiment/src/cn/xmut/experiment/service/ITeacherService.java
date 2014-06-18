package cn.xmut.experiment.service;

import cn.xmut.experiment.domain.Teacher;

public interface ITeacherService {
	/**
	 * 处理教师登陆
	 * @param teacher 教师对象
	 * @return 是否存在该教师
	 */
	public abstract boolean isTeacher(Teacher teacher);
}
