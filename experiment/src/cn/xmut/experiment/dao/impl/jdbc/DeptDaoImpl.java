package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.xmut.experiment.dao.IDeptDao;
import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.util.JdbcUtils;

public class DeptDaoImpl implements IDeptDao {

	
	public String getDeptName(int deptId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String deptName = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT deptName FROM dept WHERE deptId=?");
			ps.setInt(1, deptId);
			rs = ps.executeQuery();
			if(rs.next()) {
				deptName = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return deptName;
	}

	public List<Dept> getDeptList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT deptId,deptName FROM dept ORDER BY deptId");
			rs = ps.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptId(rs.getInt(1));
				dept.setDeptName(rs.getString(2));
				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}
	

}
