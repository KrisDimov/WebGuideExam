package web.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import service.ProductService;


public class Products extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Products");
		
		ProductService productService = new ProductService();
		List<Product> products = productService.getAllProducts();
		productService.close();
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
		
		
	}

}
