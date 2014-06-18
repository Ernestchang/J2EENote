package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.xmut.experiment.dao.IAppraisalDao;
import cn.xmut.experiment.domain.Appraisal;
import cn.xmut.experiment.util.JdbcUtils;

public class AppraisalDaoImpl implements IAppraisalDao {

	public boolean addAppraisal(int experimentId, String[] expertIds) {
		Connection conn = null;
		Statement stmt = null;
		boolean b = false;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for(int i = 0; i < expertIds.length; i++) {
				stmt.addBatch("INSERT INTO appraisal(experimentId,expertId) VALUES(" + experimentId + "," + expertIds[i] + ")");
			}
			stmt.executeBatch();
			conn.commit();
			b = true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, stmt, conn);
		}
		return b;
	}

	public List<Appraisal> getAppraisalList(int experimentId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Appraisal> list = new ArrayList<Appraisal>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT appraisalStatus,experimentType,opinion FROM appraisal WHERE experimentId=?");
			ps.setInt(1, experimentId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Appraisal appraisal = new Appraisal();
				appraisal.setAppraisalStatus(rs.getString(1));
				appraisal.setExperimentType(rs.getString(2));
				appraisal.setOpinion(rs.getString(3));
				list.add(appraisal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}

	public boolean updateAppraisal(Appraisal appraisal) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean b = false;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("UPDATE appraisal SET experimentType=?,opinion=?,appraisalStatus=? WHERE experimentId=? AND expertId=?");
			ps.setString(1, appraisal.getExperimentType());
			ps.setString(2, appraisal.getOpinion());
			ps.setString(3, appraisal.getAppraisalStatus());
			ps.setInt(4, appraisal.getExperimentId());
			ps.setString(5, appraisal.getExpertId());
			int result =  ps.executeUpdate();
			if(result == 1) {
				b = true;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return b;
	}

	public List<String> getOpinionList(int experimentId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT opinion FROM appraisal WHERE experimentId=?");
			ps.setInt(1, experimentId);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}

	

}
