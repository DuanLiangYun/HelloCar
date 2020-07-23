package com.zx.hellocar.utils;

import com.zx.hellocar.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SQLUtil {
	

	public static List<?> exceQuery(String sql,Object ... obj){
		List<Object> list = new ArrayList<>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);

			if(obj.length > 0) {
				for (int i=0;i<obj.length;i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
	        int columnCount = md.getColumnCount();
			if(rs != null) {
				while (rs.next()) {
		            Map rowData = new HashMap();
//		            List rowData = new ArrayList();
		            for (int i = 1; i <= columnCount; i++) {
		                rowData.put(md.getColumnName(i), rs.getObject(i));
//		                rowData.add(rs.getObject(i));
		            }
		            list.add(rowData);
		        }
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeAll(conn, ps, rs);
		}
	}
	
	

	public static int exceUpdate(String sql,Object ... obj)  {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);

			if(obj.length > 0) {
				for (int i=0;i<obj.length;i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			JDBCUtil.closeAll(conn, ps, null);
		}
	}
	
}
