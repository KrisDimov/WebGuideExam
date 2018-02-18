package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DBConnectionFactory;
import models.Office;

public class OfficeService extends AppService {

	public OfficeService() {
		super(DBConnectionFactory.get());
	}
	
	public List<Office> getAllOffices() {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT officeCode,city, phone, addressLine1, country, postalCode FROM offices";
			ResultSet results = statement.executeQuery(query);
			List<Office> offices = new ArrayList<>();
			while (results.next()) {
				fill(offices, results);
			}
			return offices;
		} catch (SQLException ex) {
			return Collections.emptyList();
		}
	}

	public Office getOffice(String id) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT * FROM offices WHERE officeCode=" + id;
			ResultSet result = statement.executeQuery(query);
			Office office = new Office();
			if (result.next()) {
				office.setCode(result.getInt("officeCode"));
				office.setCity(result.getString("city"));
				office.setPhone(result.getString("phone"));
				office.setAddress(result.getString("addressLine1"));
				office.setCountry(result.getString("country"));
				office.setPostCode(result.getString("postalCode"));
				
				office.setAdditionalAddress(result.getString("addressLine2"));
				office.setState(result.getString("state"));
				office.setTerritory(result.getString("territory"));
				return office;
			}
		} catch (SQLException ex) {

		}
		return null;
	}

	private void fill(List<Office> orders, ResultSet results) throws SQLException {
		Office office = new Office();
		office.setCode(results.getInt("officeCode"));
		office.setCity(results.getString("city"));
		office.setPhone(results.getString("phone"));
		office.setAddress(results.getString("addressLine1"));
		office.setCountry(results.getString("country"));
		office.setPostCode(results.getString("postalCode"));
		orders.add(office);
	}
	
}
