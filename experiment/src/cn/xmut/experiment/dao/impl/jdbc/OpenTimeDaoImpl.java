package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.xmut.experiment.dao.IOpenTimeDao;
import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.util.JdbcUtils;

public class OpenTimeDaoImpl implements IOpenTimeDao {

	public List<OpenTime> getOpenTimeList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OpenTime> list = new ArrayList<OpenTime>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT schoolYear FROM openTime GROUP BY schoolYear ORDER BY openTimeId");
			rs = ps.executeQuery();
			while(rs.next()) {
				OpenTime openTime = new OpenTime();
				openTime.setSchoolYear(rs.getString(1));
				list.add(openTime);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}

	public void getOpenTimeId(OpenTime openTime) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT openTimeId FROM openTime WHERE schoolYear=? AND schoolTerm=?");
			ps.setString(1, openTime.getSchoolYear());
			ps.setInt(2, openTime.getSchoolTerm());
			rs = ps.executeQuery();
			if(rs.next()) {
				openTime.setOpenTimeId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
	}

}
