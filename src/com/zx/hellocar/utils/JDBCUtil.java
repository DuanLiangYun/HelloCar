package com.zx.hellocar.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


/**
 * JDBC工具类
 * @Author Administrator
 * @Date 2020年7月22日 下午2:55:08
 * @Version v1.0
 */
public class JDBCUtil {

	private static String drive = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	static {
		Properties pro = new Properties();
		try {
			pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			drive = pro.getProperty("DRIVER");
			url = pro.getProperty("URL");
			user = pro.getProperty("USER");
			password = pro.getProperty("PWD");

			Class.forName(drive );
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动失败！");
		} catch (IOException e) {
			System.err.println("获取数据库连接配置文件失败！");
		}
	}


	/**
	 * 关闭资源
	 * @Date 2020年7月22日 下午2:44:35
	 * @Version v1.0
	 * @param conn	连接对象
	 * @param ps	预处理对象
	 * @param rs	结果集对象
	 * @throws SQLException
	 */
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs)  {
		try {
			if(conn != null) {
				conn.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.err.println("资源关闭失败！");
		}
	}

	/**
	 * 获取连接
	 * @Date 2020年7月22日 下午2:42:08
	 * @Version v1.0
	 * @return 连接对象
	 * @throws SQLException
	 */
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("数据库连接失败！");
			return null;
		}
	}
	
}
