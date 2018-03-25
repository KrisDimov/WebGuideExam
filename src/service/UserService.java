package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnectionFactory;
import forms.RegisterForm;
import models.User;

public class UserService extends AppService {

	public UserService() {
		super(DBConnectionFactory.get());
	}
	
	public User getUser(String email, String password) {
		String query = "SELECT name, email FROM users WHERE email='"+ email + "' AND password='" + password + "' LIMIT 1";
		Statement statement;
		try {
			statement = getConnection().createStatement();
			ResultSet result = statement.executeQuery(query);
			if(result.next()) {
				User user = new User();
				user.setName(result.getString("name"));
				user.setEmail(result.getString("email"));
				return user;
			}
		} catch (SQLException ex) {}
		return null;
	}
	
	public void createUser(RegisterForm submitForm) {
		String queryTemplate = "INSERT INTO users (name, email, password) VALUES ('#name', '#email', '#password')";
		String query = queryTemplate.replace("#name", submitForm.getName()).replaceAll("#email", submitForm.getEmail()).replaceAll("#password", submitForm.getPassword());
		try {
			getConnection().createStatement().executeUpdate(query);
		} catch (SQLException ex) {}
	}
}
