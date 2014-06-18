package util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.xmut.experiment.util.JdbcUtils;
import cn.xmut.experiment.util.MyTools;

public class TestUtil {
	@Test
	public void getConnection() {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn + "1111111");
		JdbcUtils.close(null, null, conn);
		System.out.println(conn + "2222222");
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getMD5() {
		System.out.println(MyTools.getMD5("123456"));
	}
}
