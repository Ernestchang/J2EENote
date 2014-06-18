package cn.xmut.experiment.dao.impl.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cn.xmut.experiment.dao.IExperimentDao;
import cn.xmut.experiment.domain.Experiment;
import cn.xmut.experiment.domain.ShowExperiment;
import cn.xmut.experiment.util.JdbcUtils;

public class ExperimentDaoImpl implements IExperimentDao {

	public boolean addExperiment(Experiment experiment,String docName, String dirPath, FileItem fileItem) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean b = false;
		try {
			File dir = new File(dirPath);
			File file = new File(dir, docName);
			String docPath = file.getAbsolutePath();
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO experiment(experimentName,courseId,experimentCategory,specialtyId,");
			sql.append("experimentDemand,creditHours,openTimeId,introduction,docPath,experimentType,teacherId) ");
			sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, experiment.getExperimentName());
			ps.setInt(2, experiment.getCourseId());
			ps.setString(3, experiment.getExperimentCategory());
			ps.setInt(4, experiment.getSpecialtyId());
			ps.setString(5, experiment.getExperimentDemand());
			ps.setInt(6, experiment.getCreditHours());
			ps.setInt(7, experiment.getOpenTimeId());
			ps.setString(8, experiment.getIntroduction());
			ps.setString(9, docPath);
			ps.setString(10, experiment.getExperimentType());
			ps.setString(11, experiment.getTeacherId());
			int result = ps.executeUpdate();
			if(result == 1) {
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				fileItem.write(file);
			}
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
			JdbcUtils.close(null, ps, conn);
		}
		return b;
	}
	
	public boolean updateExperiment(Experiment experiment) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean b = false;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("UPDATE experiment SET appraisalStatus=?,experimentType=? WHERE experimentId=?");
			ps.setString(1, experiment.getAppraisalStatus());
			ps.setString(2, experiment.getExperimentType());
			ps.setInt(3, experiment.getExperimentId());
			int result = ps.executeUpdate();
			if(result == 1) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return b;
	}

	public String getDocPath(int experimentId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String docPath = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT docPath FROM experiment WHERE experimentId=?");
			ps.setInt(1, experimentId);
			rs = ps.executeQuery();
			if(rs.next()) {
				docPath = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return docPath;
	}

	public Experiment getExperiment(int experimentId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Experiment experiment = new Experiment();
		experiment.setExperimentId(experimentId);
		try {
			conn = JdbcUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT courseName,experimentName,experimentCategory,schoolYear,schoolTerm,");
			sql.append("experimentDemand,specialtyName,creditHours,experimentType,introduction ");
			sql.append("FROM experiment,course,specialty,openTime ");
			sql.append("WHERE experiment.courseId=course.courseId AND experiment.specialtyId=specialty.specialtyId ");
			sql.append("AND experiment.openTimeId=openTime.openTimeId AND experimentId=?");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, experimentId);
			rs = ps.executeQuery();
			if(rs.next()) {
				experiment.setCourseName(rs.getString(1));
				experiment.setExperimentName(rs.getString(2));
				experiment.setExperimentCategory(rs.getString(3));
				experiment.setSchoolYear(rs.getString(4));
				experiment.setSchoolTerm(rs.getInt(5));
				experiment.setExperimentDemand(rs.getString(6));
				experiment.setSpecialtyName(rs.getString(7));
				experiment.setCreditHours(rs.getInt(8));
				experiment.setExperimentType(rs.getString(9));
				experiment.setIntroduction(rs.getString(10));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return experiment;
	}

	public List<ShowExperiment> queryPass(Experiment experiment) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShowExperiment> list = new ArrayList<ShowExperiment>();
		try {
			conn = JdbcUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT experimentId,experimentName ");
			sql.append("FROM experiment ");
			sql.append("WHERE appraisalStatus='通过' AND courseId=? ");
			sql.append("AND openTimeId=(SELECT openTimeId FROM openTime WHERE schoolYear=? AND schoolTerm=?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, experiment.getCourseId());
			ps.setString(2, experiment.getSchoolYear());
			ps.setInt(3, experiment.getSchoolTerm());
			rs = ps.executeQuery();
			while(rs.next()) {
				ShowExperiment showExperiment = new ShowExperiment();
				showExperiment.setExperimentId(rs.getInt(1));
				showExperiment.setExperimentName(rs.getString(2));
				list.add(showExperiment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return list;
	}

	public List<ShowExperiment> queryNodistribute(Experiment experiment) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShowExperiment> list = new ArrayList<ShowExperiment>();
		try {
			conn = JdbcUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT experimentId,experimentName ");
			sql.append("FROM experiment ");
			sql.append("WHERE courseId=? AND appraisalStatus IS NULL ");
			sql.append("AND openTimeId=(SELECT openTimeId FROM openTime WHERE schoolYear=? AND schoolTerm=?) ");
			sql.append("AND experimentId NOT IN (SELECT DISTINCT experimentId FROM appraisal)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, experiment.getCourseId());
			ps.setString(2, experiment.getSchoolYear());
			ps.setInt(3, experiment.getSchoolTerm());
			rs = ps.executeQuery();
			while(rs.next()) {
				ShowExperiment showExperiment = new ShowExperiment();
				showExperiment.setExperimentId(rs.getInt(1));
				showExperiment.setExperimentName(rs.getString(2));
				list.add(showExperiment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return list;
	}

	public List<ShowExperiment> expertQueryNoExtimate(Experiment experiment, String expertId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShowExperiment> list = new ArrayList<ShowExperiment>();
		try {
			conn = JdbcUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT experimentId,experimentName ");
			sql.append("FROM experiment WHERE courseId=? ");
			sql.append("AND experimentId IN(SELECT experimentId FROM appraisal WHERE expertId=? AND appraisal.experimentType IS NULL) ");
			sql.append("AND openTimeId=(SELECT openTimeId FROM openTime WHERE schoolYear=? AND schoolTerm=?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, experiment.getCourseId());
			ps.setString(2, expertId);
			ps.setString(3, experiment.getSchoolYear());
			ps.setInt(4, experiment.getSchoolTerm());
			rs = ps.executeQuery();
			while(rs.next()) {
				ShowExperiment showExperiment = new ShowExperiment();
				showExperiment.setExperimentId(rs.getInt(1));
				showExperiment.setExperimentName(rs.getString(2));
				list.add(showExperiment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return list;
	}

	public List<ShowExperiment> managerQueryNoExtimate(Experiment experiment) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShowExperiment> list = new ArrayList<ShowExperiment>();
		try {
			conn = JdbcUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT experimentId,experimentName ");
			sql.append("FROM experiment ");
			sql.append("WHERE courseId=? AND appraisalStatus IS NULL  ");
			sql.append("AND 3=(SELECT COUNT(*) FROM appraisal WHERE experiment.experimentId=appraisal.experimentId AND appraisal.appraisalStatus IS NOT NULL) ");
			sql.append("AND openTimeId=(SELECT openTimeId FROM openTime WHERE schoolYear=? AND schoolTerm=?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, experiment.getCourseId());
			ps.setString(2, experiment.getSchoolYear());
			ps.setInt(3, experiment.getSchoolTerm());
			rs = ps.executeQuery();
			while(rs.next()) {
				ShowExperiment showExperiment = new ShowExperiment();
				showExperiment.setExperimentId(rs.getInt(1));
				showExperiment.setExperimentName(rs.getString(2));
				list.add(showExperiment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return list;
	}

	public List<ShowExperiment> managerQueryNoPass(Experiment experiment) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShowExperiment> list = new ArrayList<ShowExperiment>();
		try {
			conn = JdbcUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT experimentId,experimentName ");
			sql.append("FROM experiment ");
			sql.append("WHERE appraisalStatus='未通过' AND courseId=? ");
			sql.append("AND openTimeId=(SELECT openTimeId FROM openTime WHERE schoolYear=? AND schoolTerm=?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, experiment.getCourseId());
			ps.setString(2, experiment.getSchoolYear());
			ps.setInt(3, experiment.getSchoolTerm());
			rs = ps.executeQuery();
			while(rs.next()) {
				ShowExperiment showExperiment = new ShowExperiment();
				showExperiment.setExperimentId(rs.getInt(1));
				showExperiment.setExperimentName(rs.getString(2));
				list.add(showExperiment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return list;
	}

	public boolean delExperiment(Experiment experiment) {
		Connection conn = null;
		Statement stmt = null;
		boolean b = false;
		try {
			String docPath = experiment.getDocPath();
			File file = new File(docPath);
			if(file.exists() && file.isFile()) {
				conn = JdbcUtils.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				stmt.addBatch("DELETE FROM appraisal WHERE experimentId=" + experiment.getExperimentId());
				stmt.addBatch("DELETE FROM experiment WHERE experimentId=" + experiment.getExperimentId());
				int[] result = stmt.executeBatch();
				if(result.length > 0) {
					file.delete();
				}
			}
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

	public List<ShowExperiment> headmanQueryNoPass(Experiment experiment) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShowExperiment> list = new ArrayList<ShowExperiment>();
		try {
			conn = JdbcUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT experimentId,experimentName ");
			sql.append("FROM experiment ");
			sql.append("WHERE courseId=? AND teacherId=? AND appraisalStatus='未通过' ");
			sql.append("AND openTimeId=(SELECT openTimeId FROM openTime WHERE schoolYear=? AND schoolTerm=?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, experiment.getCourseId());
			ps.setString(2, experiment.getTeacherId());
			ps.setString(3, experiment.getSchoolYear());
			ps.setInt(4, experiment.getSchoolTerm());
			rs = ps.executeQuery();
			while(rs.next()) {
				ShowExperiment showExperiment = new ShowExperiment();
				showExperiment.setExperimentId(rs.getInt(1));
				showExperiment.setExperimentName(rs.getString(2));
				list.add(showExperiment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, conn);
		}
		return list;
	}
}
