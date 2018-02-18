package web.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import service.EmployeeService;

public class Employees extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Employees");
		
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.getAllEmployees();
		employeeService.close();
		
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("WEB-INF/pages/employees.jsp").forward(request, response);
		
	}

}
