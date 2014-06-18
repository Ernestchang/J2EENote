package cn.xmut.experiment.service.impl;

import cn.xmut.experiment.dao.ITeacherDao;
import cn.xmut.experiment.dao.impl.jdbc.TeacherDaoImpl;
import cn.xmut.experiment.domain.Teacher;
import cn.xmut.experiment.service.ITeacherService;

public class TeacherServiceImpl implements ITeacherService {
	private ITeacherDao teacherDao = new TeacherDaoImpl();

	public boolean isTeacher(Teacher teacher) {
		return teacherDao.isTeacher(teacher);
	}
	
}
