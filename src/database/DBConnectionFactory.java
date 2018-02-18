package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionFactory {

	private static final String HOST = "localhost:3306/";
	
	private static final String DATABASE = "classicmodels";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	private DBConnectionFactory() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Cannot connect to DB, " + ex.getMessage());
		}
	}
	
	public static Connection get() {
		try {
			return DriverManager.getConnection("jdbc:mysql://" + HOST + DATABASE, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			System.out.println("Cannot create connection to DB, " + ex.getMessage());
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
