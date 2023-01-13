package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static String url="jdbc:mysql://localhost:3306/studentManager?useUnicode=true&characterEncoding=utf8";
	private static String username="root"; // 用户名
	private static String password="root"; // 密码
	private static String jdbcName="com.mysql.jdbc.Driver"; // 驱动名

	
	public static Connection  getCon() {
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败！");
		}
		return con;
	}

	// 关闭数据库连接
	public void closeCon(Connection con)throws Exception{
		if(con != null){
			con.close();
		}
	}

}
