package com.tekpyramid.chaingrid.generic_utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ChainGrid_Database_Utility {
	Connection conn;

	/*
	 * Connect to Database
	 */
	public void connectToDB() throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Execute a select Query
	 */
	ResultSet result;

	public ResultSet executeSelectQuery(String Query) throws SQLException {
		try {
			connectToDB();
			Statement state = conn.createStatement();
		   result = state.executeQuery(Query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	/*
	 * Execute a Update Query
	 */
	public int updateQuery(String updateQuery1) throws SQLException {
		int result1 = 0;
		try {
			connectToDB();
			Statement state = conn.createStatement();
			result1 = state.executeUpdate(updateQuery1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result1;
	}
	
	/*
	 * Close the Connection of Database
	 */
	public void closeConnOfDB() throws SQLException {
		conn.close();
	}
	
	/*
	 * To check the Expected Data is present in perticular coloum  or not
	 */
	String ExpData;
	String Actdata;
	public void checkExpDataInDB(String query, int coloumIndex, String ExpData) throws SQLException {
		try {
			connectToDB();
			Statement state = conn.createStatement();
		    result = state.executeQuery(query);
		    while(result.next()) {
		    	Actdata = result.getString(coloumIndex);
		    	if(Actdata.equalsIgnoreCase(ExpData)) {
		    		System.out.println(Actdata+" is present");
		    		break;
		    	}
		    	else {
		    		System.out.println(Actdata+" is not present");
		    	}
		    }
	    		
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
}
