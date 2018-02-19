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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		if (uri.endsWith("offices") || uri.endsWith("offices/")) {

			request.setAttribute("title", "Offices");

			OfficeService officeService = new OfficeService();
			List<Office> offices = officeService.getAllOffices();
			officeService.close();

			request.setAttribute("offices", offices);
			request.getRequestDispatcher("/WEB-INF/pages/offices.jsp").forward(request, response);

		} else {

			OfficeService officeService = new OfficeService();
			String idParam = request.getParameter("id");
			Office office = officeService.getOffice(idParam);
			officeService.close();

			request.setAttribute("title", "Office " + idParam);
			request.setAttribute("office", office);
			request.getRequestDispatcher("/WEB-INF/pages/single/officeDetails.jsp").forward(request, response);

		}
	}

}
