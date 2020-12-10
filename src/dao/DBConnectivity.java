package dao;

import java.sql.*;

public class DBConnectivity {
	
	static Connection con = null;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "D@ta00Found");  //Enter your password
			System.out.println("Connection done");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static Connection getConnection() {		
		return con;
	}
}
