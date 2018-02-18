package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DBConnectionFactory;
import models.Employee;
import models.Office;

public class EmployeeService extends AppService {

	public EmployeeService() {
		super(DBConnectionFactory.get());
	}

	public List<Employee> getAllEmployees() {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT employeeNumber, firstName, lastName, email, jobTitle FROM employees";
			ResultSet results = statement.executeQuery(query);
			List<Employee> employees = new ArrayList<>();
			while (results.next()) {
				fill(employees, results);
			}
			return employees;
		} catch (SQLException ex) {
			return Collections.emptyList();
		}
	}

	public Employee getEmployee(String id) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT e.employeeNumber, e.firstName, e.lastName, e.extension, e.email, boss.firstName, boss.lastName, e.jobTitle, o.city, o.country FROM ((employees e LEFT JOIN employees boss ON e.reportsTo=boss.employeeNumber) INNER JOIN offices o ON e.officeCode=o.officeCode) WHERE e.employeeNumber="
					+ id;
			ResultSet result = statement.executeQuery(query);
			Employee employee = new Employee();
			if (result.next()) {
				employee.setNumber(result.getInt("e.employeeNumber"));
				employee.setFirstName(result.getString("e.firstName"));
				employee.setLastName(result.getString("e.lastName"));
				employee.setEmail(result.getString("e.email"));
				employee.setJobTitle(result.getString("e.jobTitle"));
				
				employee.setExtension(result.getString("e.extension"));
				employee.setCity(result.getString("o.city"));
				employee.setCountry(result.getString("o.country"));
				String boss = "";
				if (result.getString("boss.firstName") != null){
					boss = result.getString("boss.firstName") + " " + result.getString("boss.lastName");
				} 
				employee.setBoss(boss);
				
				return employee;
			}
		} catch (SQLException ex) {

		}
		return null;
	}

	private void fill(List<Employee> orders, ResultSet results) throws SQLException {
		Employee employee = new Employee();
		employee.setNumber(results.getInt("employeeNumber"));
		employee.setFirstName(results.getString("firstName"));
		employee.setLastName(results.getString("lastName"));
		employee.setEmail(results.getString("email"));
		employee.setJobTitle(results.getString("jobTitle"));
		orders.add(employee);
	}

}
