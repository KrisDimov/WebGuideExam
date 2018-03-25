package web.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Payment;
import service.PaymentService;
import util.Constants;

public class Payments extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();

		if (uri.endsWith("payments") || uri.endsWith("payments/")) {

			request.setAttribute("title", "Payments");

			PaymentService paymentService = new PaymentService();
			List<Payment> payments = paymentService.getAllPayments();
			paymentService.close();

			request.setAttribute("payments", payments);
			request.getRequestDispatcher("WEB-INF/pages/payments.jsp").forward(request, response);

		} else {

			PaymentService paymentService = new PaymentService();
			String idParam = request.getParameter("id");
			Payment payment = paymentService.getPayment(idParam);
			paymentService.close();

			request.setAttribute("title", "Payment " + payment.toString());
			request.setAttribute("payment", payment);
			request.getRequestDispatcher("/WEB-INF/pages/single/paymentDetails.jsp").forward(request, response);

		}
	}

}
