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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		if (uri.endsWith("products") || uri.endsWith("products/")) {

			request.setAttribute("title", "Products");

			ProductService productService = new ProductService();
			List<Product> products = productService.getAllProducts();
			productService.close();

			request.setAttribute("products", products);
			request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);

		} else {

			ProductService productService = new ProductService();

			String idParam = request.getParameter("id");
			Product product = productService.getProduct(idParam);
			productService.close();

			request.setAttribute("product", product);
			request.setAttribute("title", "Product " + product.toString());

			request.getRequestDispatcher("/WEB-INF/pages/single/productDetails.jsp").forward(request, response);

		}

	}

}
