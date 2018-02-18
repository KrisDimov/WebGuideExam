package web.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import service.CustomerService;

public class CustomerDetails extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerService customerService = new CustomerService();
		String idParam = request.getParameter("id");
		Customer customer = customerService.getCustomer(idParam);
		customerService.close();
		
		request.setAttribute("customer", customer);
		request.setAttribute("title", "Customer " + idParam);
		request.getRequestDispatcher("/WEB-INF/pages/single/customerDetails.jsp").forward(request, response);
		
	}
	
}
