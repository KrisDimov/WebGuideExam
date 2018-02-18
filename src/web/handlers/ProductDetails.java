package web.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import service.ProductService;

public class ProductDetails extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService productService = new ProductService();
		
		String idParam = request.getParameter("id");
		Product product = productService.getProduct(idParam);
		productService.close();
		
		request.setAttribute("product", product);
		request.setAttribute("title", "Product " + idParam);
		
		request.getRequestDispatcher("/WEB-INF/pages/single/productDetails.jsp").forward(request, response);
		
	}
	
}
