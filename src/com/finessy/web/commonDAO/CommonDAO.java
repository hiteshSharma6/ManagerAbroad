package com.finessy.web.commonDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		Class.forName(rb.getString("drivername"));
		Connection con = DriverManager.getConnection(rb.getString("dburl"),rb.getString("userid"),rb.getString("password"));
		System.out.println("Connection established");
		System.out.println(con.getCatalog());
		return con;
	}
	
}
