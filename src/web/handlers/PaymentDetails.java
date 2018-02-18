package web.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Payment;
import service.PaymentService;

public class PaymentDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PaymentService paymentService = new PaymentService();
		String idParam = request.getParameter("id");
		Payment payment = paymentService.getPayment(idParam);
		paymentService.close();
		
		request.setAttribute("title", "Payment " + idParam);
		request.setAttribute("payment", payment);
		request.getRequestDispatcher("/WEB-INF/pages/single/paymentDetails.jsp").forward(request, response);
		
	}

}
