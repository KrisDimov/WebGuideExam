package web.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Payment;
import service.PaymentService;

public class Payments extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Payments");
		
		PaymentService paymentService = new PaymentService();
		List<Payment> payments = paymentService.getAllPayments();
		paymentService.close();
		
		request.setAttribute("payments", payments);
		request.getRequestDispatcher("WEB-INF/pages/payments.jsp").forward(request, response);
		
	}

}
