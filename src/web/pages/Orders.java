package web.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;
import service.OrderService;

public class Orders extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		
		if (uri.endsWith("orders") || uri.endsWith("orders/")) {

			request.setAttribute("title", "Orders");

			OrderService ordersService = new OrderService();
			List<Order> orders = ordersService.getAllOrders();
			ordersService.close();

			request.setAttribute("orders", orders);
			request.getRequestDispatcher("/WEB-INF/pages/orders.jsp").forward(request, response);

		} else {

			OrderService orderService = new OrderService();
			String idParam = request.getParameter("id");
			Order order = orderService.getOrder(idParam);
			List<Order> orderDetails = orderService.getOrderDetails(idParam);
			orderService.close();

			request.setAttribute("orderDetails", orderDetails);
			request.setAttribute("order", order);
			request.setAttribute("title", "Order " + order.toString());

			request.getRequestDispatcher("/WEB-INF/pages/single/orderDetails.jsp").forward(request, response);

		}
	}

}
