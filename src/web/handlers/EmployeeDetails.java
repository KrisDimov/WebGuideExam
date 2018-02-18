package web.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import service.EmployeeService;

public class EmployeeDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeService();
		String idParam = request.getParameter("id");
		Employee employee = employeeService.getEmployee(idParam);
		employeeService.close();
		
		request.setAttribute("title", "Employee " + idParam);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/pages/single/employeeDetails.jsp").forward(request, response);
		
	}

}