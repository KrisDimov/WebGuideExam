package web.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import service.CustomerService;

public class Customers extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Customers");
		
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAllCustomers();
		customerService.close();
		
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/WEB-INF/pages/customers.jsp").forward(request, response);
		
	}

}
