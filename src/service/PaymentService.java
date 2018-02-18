package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DBConnectionFactory;
import models.Payment;

public class PaymentService extends AppService {

	public PaymentService() {
		super(DBConnectionFactory.get());
	}

	public List<Payment> getAllPayments() {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT customerNumber, checkNumber, paymentDate, amount FROM payments";
			ResultSet results = statement.executeQuery(query);
			List<Payment> payments = new ArrayList<>();
			while (results.next()) {
				fill(payments, results);
			}
			return payments;
		} catch (SQLException ex) {
			return Collections.emptyList();
		}
	}

	public Payment getPayment(String id) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String query = "SELECT p.customerNumber, c.customerName, p.checkNumber, p.paymentDate, p.amount FROM payments p INNER JOIN customers c ON p.customerNumber=c.customerNumber WHERE p.checkNumber='"
					+ id + "'";
			ResultSet result = statement.executeQuery(query);
			Payment payment = new Payment();
			if (result.next()) {
				payment.setCustomerNumber(result.getInt("p.customerNumber"));
				payment.setCheckNumber(result.getString("p.checkNumber"));
				payment.setPaymentDate(result.getDate("p.paymentDate"));
				payment.setAmount(result.getFloat("p.amount"));
				payment.setCustomerName(result.getString("c.customerName"));
			}
			return payment;
		} catch (SQLException ex) {

		}
		return null;
	}

	private void fill(List<Payment> payments, ResultSet results) throws SQLException {
		Payment payment = new Payment();
		payment.setCustomerNumber(results.getInt("customerNumber"));
		payment.setCheckNumber(results.getString("checkNumber"));
		payment.setPaymentDate(results.getDate("paymentDate"));
		payment.setAmount(results.getFloat("amount"));
		payments.add(payment);
	}

}
