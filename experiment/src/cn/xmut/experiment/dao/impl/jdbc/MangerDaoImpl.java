package cn.xmut.experiment.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.xmut.experiment.dao.IManagerDao;
import cn.xmut.experiment.domain.Manager;
import cn.xmut.experiment.util.JdbcUtils;

public class MangerDaoImpl implements IManagerDao {

	public boolean isManager(Manager manager) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean b = false;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement("SELECT managerName,deptId FROM manager WHERE managerId=? AND managerPassword=?");
			ps.setString(1, manager.getManagerId());
			ps.setString(2, manager.getManagerPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				manager.setManagerName(rs.getString(1));
				manager.setDeptId(rs.getInt(2));
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
