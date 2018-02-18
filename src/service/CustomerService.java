package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DBConnectionFactory;
import models.Customer;

public class CustomerService extends AppService {

	public CustomerService() {
		super(DBConnectionFactory.get());
	}

	public List<Customer> getAllCustomers() {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT customerNumber, customerName, contactFirstName, contactLastName, phone, addressLine1 FROM customers";
			ResultSet results = statement.executeQuery(query);
			List<Customer> customers = new ArrayList<>();
			while (results.next()) {
				fill(customers, results);
			}
			return customers;
		} catch (SQLException ex) {
			return Collections.emptyList();
		}
	}

	public Customer getCustomer(String id) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT customerNumber, customerName, contactFirstName, contactLastName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit FROM customers WHERE customerNumber="
					+ id;
			ResultSet result = statement.executeQuery(query);

			Customer customer = new Customer();
			if (result.next()) {
				customer.setNumber(result.getInt("customerNumber"));
				customer.setName(result.getString("customerName"));
				customer.setLastName(result.getString("contactLastName"));
				customer.setFirstName(result.getString("contactFirstName"));
				customer.setPhone(result.getString("phone"));
				customer.setAddress(result.getString("addressLine1"));

				customer.setAdditionalAddress(result.getString("addressLine2"));
				customer.setCity(result.getString("city"));
				customer.setState(result.getString("state"));
				customer.setPostalCode(result.getString("postalCode"));
				customer.setCountry(result.getString("country"));
				customer.setSalesRepEmpNum(result.getString("salesRepEmployeeNumber"));
				customer.setCreditLimit(result.getInt("creditLimit"));
				return customer;
			} else {
			}

		} catch (SQLException ex) {

		}
		return null;
	}

	private void fill(List<Customer> customers, ResultSet results) throws SQLException {
		Customer customer = new Customer();
		customer.setNumber(results.getInt("customerNumber"));
		customer.setName(results.getString("customerName"));
		customer.setFirstName(results.getString("contactFirstName"));
		customer.setLastName(results.getString("contactLastName"));
		customer.setPhone(results.getString("phone"));
		customer.setAddress(results.getString("addressLine1"));
		customers.add(customer);
	}

}
