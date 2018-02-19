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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		if (uri.endsWith("employees") || uri.endsWith("employees/")) {

			request.setAttribute("title", "Employees");

			EmployeeService employeeService = new EmployeeService();
			List<Employee> employees = employeeService.getAllEmployees();
			employeeService.close();

			request.setAttribute("employees", employees);
			request.getRequestDispatcher("WEB-INF/pages/employees.jsp").forward(request, response);

		} else {

			EmployeeService employeeService = new EmployeeService();
			String idParam = request.getParameter("id");
			Employee employee = employeeService.getEmployee(idParam);
			employeeService.close();

			request.setAttribute("title", "Employee " + idParam);
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("/WEB-INF/pages/single/employeeDetails.jsp").forward(request, response);

		}
	}

}
