package web.pages.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.RegisterForm;
import service.UserService;

public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Register");
		if (request.getAttribute("registerForm") == null) {
			RegisterForm defaultEmptyForm = new RegisterForm();
			request.setAttribute("registerForm", defaultEmptyForm);
		}
		request.getRequestDispatcher("/WEB-INF/pages/admin/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterForm submitForm = RegisterForm.fromRequest(request);
		if (submitForm.valid()) {
			UserService userService = new UserService();
			userService.createUser(submitForm);
			userService.close();
			response.sendRedirect("/WebGuideExam/login");
		} else {
			request.setAttribute("registerForm", submitForm);
			doGet(request, response);
		}
	}
	
}
