package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DBConnectionFactory;
import models.Order;

public class OrderService extends AppService {

	public OrderService() {
		super(DBConnectionFactory.get());
	}

	public List<Order> getAllOrders() {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT orderNumber, orderDate, shippedDate, comments, status FROM orders";
			ResultSet results = statement.executeQuery(query);
			List<Order> orders = new ArrayList<>();
			while (results.next()) {
				fill(orders, results);
			}
			return orders;
		} catch (SQLException ex) {
			return Collections.emptyList();
		}
	}

	public Order getOrder(String id) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT o.orderNumber, o.orderDate, o.shippedDate, o.status, c.customerName FROM orders o INNER JOIN customers c ON o.customerNumber=c.customerNumber WHERE o.orderNumber='"
					+ id + "'";
			ResultSet result = statement.executeQuery(query);
			Order order = new Order();
			if (result.next()) {
				order.setNumber(result.getInt("o.orderNumber"));
				order.setOrderDate(result.getDate("o.orderDate"));
				order.setShippedDate(result.getDate("o.shippedDate"));
				order.setCustomerName(result.getString("c.customerName"));
				order.setStatus(result.getString("o.status"));
				return order;
			}
		} catch (SQLException ex) {

		}
		return null;
	}

	public List<Order> getOrderDetails(String id) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT p.productName, o.quantityOrdered, p.buyPrice FROM orderdetails o INNER JOIN products p ON o.productCode=p.productCode WHERE o.orderNumber="
					+ id;
			ResultSet result = statement.executeQuery(query);
			List<Order> orderDetails = new ArrayList<>();
			while (result.next()) {
				Order order = new Order();
				order.setProductName(result.getString("p.productName"));
				order.setQuantity(result.getInt("o.quantityOrdered"));
				order.setPrice(result.getFloat("p.buyPrice"));
				orderDetails.add(order);
			}
			return orderDetails;
		} catch (SQLException ex) {

		}
		return Collections.emptyList();
	}

	private void fill(List<Order> orders, ResultSet results) throws SQLException {
		Order order = new Order();
		order.setNumber(results.getInt("orderNumber"));
		order.setOrderDate(results.getDate("orderDate"));
		order.setShippedDate(results.getDate("shippedDate"));
		order.setComments(results.getString("comments"));
		order.setStatus(results.getString("status"));
		orders.add(order);
	}

}
