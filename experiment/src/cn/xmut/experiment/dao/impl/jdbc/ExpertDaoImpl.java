package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.xmut.experiment.dao.IExpertDao;
import cn.xmut.experiment.domain.Expert;
import cn.xmut.experiment.domain.ShowExpert;
import cn.xmut.experiment.util.JdbcUtils;

public class ExpertDaoImpl implements IExpertDao {

	public boolean isExpert(Expert expert) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean b = false;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT expertName FROM expert WHERE expertId=? AND expertPassword=?");
			ps.setString(1, expert.getExpertId());
			ps.setString(2, expert.getExpertPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				expert.setExpertName(rs.getString(1));
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return b;
	}

	public List<ShowExpert> getExpertList(int specialtyId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShowExpert> list = new ArrayList<ShowExpert>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT expertId,expertName FROM expert WHERE specialtyId=?");
			ps.setInt(1, specialtyId);
			rs = ps.executeQuery();
			while(rs.next()) {
				ShowExpert showExpert = new ShowExpert();
				showExpert.setExpertId(rs.getString(1));
				showExpert.setExpertName(rs.getString(2));
				list.add(showExpert);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return list;
	}

}
