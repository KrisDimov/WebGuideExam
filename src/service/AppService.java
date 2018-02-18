package service;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AppService {

	private Connection connection;
	
	public AppService(Connection connection) {
		this.connection = connection;
	}
	
	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				
			}
		}
	}
	
	protected Connection getConnection() {
		return connection;
	}
	
}
