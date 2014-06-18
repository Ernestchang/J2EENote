package cn.xmut.experiment.dao;

import cn.xmut.experiment.domain.Teacher;

public interface ITeacherDao {
	/**
	 * 处理教师登陆
	 * @param teacher 教师对象
	 * @return 是否存在该教师
	 */
	public abstract boolean isTeacher(Teacher teacher);
}
