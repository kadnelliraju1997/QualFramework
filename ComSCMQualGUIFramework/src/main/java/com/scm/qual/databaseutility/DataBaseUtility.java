package com.scm.qual.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * @author RAJU
 */
public class DataBaseUtility {
	public Connection conn;
	public Statement state;

	/**
	 * @author RAJU
	 */
	public void connectToDatabase() {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("url", "un", "pw");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author RAJU
	 * @param query
	 * @return
	 */
	public ResultSet executeTheSelectQuery(String query) {
		ResultSet set = null;
		try {
			state = conn.createStatement();
			set = state.executeQuery(query);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return set;
	}
	
	/**
	 * @author RAJU
	 * @param query
	 * @return
	 */


	public int updateQuery(String query) {
		int set = 0;
		try {
			set = state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}
/**
 * @author RAJU
 */
	public void closeDatabase() {

		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
