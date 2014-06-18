package cn.xmut.experiment.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static Connection conn = null;
	private static String driver = "";
	private static String url = "";
	private static String username = "";
	private static String password = "";
	private static Properties pp = null;
	private static InputStream is = null;
	
	static {
		try {
			pp = new Properties();
			//当使用java web的时候，读取文件要用类加载器(类加载器去读取资源的时候默认的主目录是src目录)
			is = JdbcUtils.class.getClassLoader().getResourceAsStream("cn/xmut/experiment/dao/impl/jdbc/config/dbconfig.properties");
			pp.load(is);
			driver = pp.getProperty("driverClassName");
			url = pp.getProperty("url");
			username = pp.getProperty("username");
			password = pp.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(is != null) {
					is.close();
					is = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//获取连接
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭连接
	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) {
					st.close();
					st = null;
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
						conn = null;
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
