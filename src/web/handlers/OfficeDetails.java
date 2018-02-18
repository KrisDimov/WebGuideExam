package web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Office;
import service.OfficeService;

public class OfficeDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OfficeService officeService = new OfficeService();
		String idParam = request.getParameter("id");
		Office office = officeService.getOffice(idParam);
		officeService.close();
		
		request.setAttribute("title", "Office " + idParam);
		request.setAttribute("office", office);
		request.getRequestDispatcher("/WEB-INF/pages/single/officeDetails.jsp").forward(request, response);
		
	}

}
