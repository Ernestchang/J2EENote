package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.xmut.experiment.dao.ISpecialtyDao;
import cn.xmut.experiment.domain.Specialty;
import cn.xmut.experiment.util.JdbcUtils;

public class SpecialtyDaoImpl implements ISpecialtyDao {

	public List<Specialty> getSpecialtyList(int deptId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Specialty> list = new ArrayList<Specialty>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT specialtyId,specialtyName FROM specialty WHERE deptId=?");
			ps.setInt(1, deptId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Specialty specialty = new Specialty();
				specialty.setSpecialtyId(rs.getInt(1));
				specialty.setSpecialtyName(rs.getString(2));
				list.add(specialty);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}

}
