package web.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Office;
import service.OfficeService;

public class Offices extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Offices");
		
		OfficeService officeService = new OfficeService();
		List<Office> offices = officeService.getAllOffices();
		officeService.close();
		
		request.setAttribute("offices", offices);
		request.getRequestDispatcher("/WEB-INF/pages/offices.jsp").forward(request, response);
		
	}

}
