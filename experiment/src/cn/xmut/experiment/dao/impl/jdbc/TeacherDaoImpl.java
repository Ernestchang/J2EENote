package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.xmut.experiment.dao.ITeacherDao;
import cn.xmut.experiment.domain.Teacher;
import cn.xmut.experiment.util.JdbcUtils;

public class TeacherDaoImpl implements ITeacherDao {

	public boolean isTeacher(Teacher teacher) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean b = false;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT teacherName,deptId FROM teacher WHERE teacherId=? AND teacherPassword=? AND teacherType=?");
			ps.setString(1, teacher.getTeacherId());
			ps.setString(2, teacher.getTeacherPassword());
			ps.setString(3, teacher.getTeacherType());
			rs = ps.executeQuery();
			if(rs.next()) {
				teacher.setTeacherName(rs.getString(1));
				teacher.setDeptId(rs.getInt(2));
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return b;
	}

}
