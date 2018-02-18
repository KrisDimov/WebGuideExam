package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DBConnectionFactory;
import models.Product;

public class ProductService extends AppService {

	public ProductService() {
		super(DBConnectionFactory.get());
	}

	public List<Product> getAllProducts() {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT productCode, productName, productLine, quantityInStock, buyPrice FROM products";
			ResultSet results = statement.executeQuery(query);
			List<Product> products = new ArrayList<>();
			while (results.next()) {
				fill(products, results);
			}
			return products;
		} catch (SQLException ex) {
			return Collections.emptyList();
		}
	}

	public Product getProduct(String id) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT productCode, productName, buyPrice, quantityInStock, productVendor, productScale FROM products WHERE productCode='" + id + "'";
			ResultSet result = statement.executeQuery(query);
			Product product = new Product();
			if (result.next()) {
				product.setCode(result.getString("productCode"));
				product.setName(result.getString("productName"));
				product.setScale(result.getString("productScale"));
				product.setVendor(result.getString("productVendor"));
				product.setQuantity(result.getInt("quantityInStock"));
				product.setPrice(result.getFloat("buyPrice"));
				return product;
			}
		} catch (SQLException ex) {

		}
		return null;
	}

	private void fill(List<Product> products, ResultSet results) throws SQLException {
		Product product = new Product();
		product.setCode(results.getString("productCode"));
		product.setName(results.getString("productName"));
		product.setLine(results.getString("productLine"));
		product.setQuantity(results.getInt("quantityInStock"));
		product.setPrice(results.getFloat("buyPrice"));
		products.add(product);
	}

}
