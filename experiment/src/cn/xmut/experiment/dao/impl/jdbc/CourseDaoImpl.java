package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.xmut.experiment.dao.ICourseDao;
import cn.xmut.experiment.domain.Course;
import cn.xmut.experiment.util.JdbcUtils;

public class CourseDaoImpl implements ICourseDao {

	public List<Course> getCourseListByDeptId(int deptId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> list = new ArrayList<Course>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT courseId,courseName FROM course WHERE deptId=?");
			ps.setInt(1, deptId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				list.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}

}
