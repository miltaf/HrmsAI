package com.hrms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	/**
	 * this method will establish a connection with db
	 */

	public static void getConnection() {
		try {
			conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method will close connection with db
	 */

	public static void closeConnection() {
		try {
			if (rs != null) {

				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
