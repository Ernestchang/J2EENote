package cn.xmut.experiment.service.impl;

import java.util.List;

import cn.xmut.experiment.dao.ICourseDao;
import cn.xmut.experiment.dao.impl.jdbc.CourseDaoImpl;
import cn.xmut.experiment.domain.Course;
import cn.xmut.experiment.service.ICourseService;

public class CourseServiceImpl implements ICourseService {
	private ICourseDao courseDao = new CourseDaoImpl();
	public List<Course> getCourseListByDeptId(int deptId) {
		return courseDao.getCourseListByDeptId(deptId);
	}

}
