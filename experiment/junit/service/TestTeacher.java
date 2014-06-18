package service;

import org.junit.Test;

import cn.xmut.experiment.dao.ITeacherDao;
import cn.xmut.experiment.dao.impl.jdbc.TeacherDaoImpl;
import cn.xmut.experiment.domain.Teacher;

public class TestTeacher {

	@Test
	public void isTeacher() {
		ITeacherDao teacherDao = new TeacherDaoImpl();
		Teacher teacher = new Teacher("0000000001", "e10adc3949ba59abbe56e057f20f883e", "课程组长");
		if(teacherDao.isTeacher(teacher)) {
			System.out.println(teacher.getTeacherName());
			System.out.println(teacher.getDeptId());
		}
	}
}
