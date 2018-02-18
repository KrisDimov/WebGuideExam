package web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;
import service.OrderService;

public class OrderDetails extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderService orderService = new OrderService();
		String idParam = request.getParameter("id");
		Order order = orderService.getOrder(idParam);
		List<Order> orderDetails = orderService.getOrderDetails(idParam);
		orderService.close();
		
		request.setAttribute("orderDetails", orderDetails);
		request.setAttribute("order", order);
		request.setAttribute("title", "Order " + idParam);
		
		request.getRequestDispatcher("/WEB-INF/pages/single/orderDetails.jsp").forward(request, response);
		
	}
	
}
