package web.pages.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import service.UserService;
import util.Constants;

public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute(Constants.DESIRED_PAGE) != null) {
			request.setAttribute("requirement", true);
			session.setAttribute(Constants.DESIRED_PAGE, null);
		}
		request.setAttribute("title", "Login");
		request.getRequestDispatcher("/WEB-INF/pages/admin/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		User foundUser = userService.getUser(username, password);
		userService.close();
		
		if (foundUser == null) {
			request.setAttribute("error", true);
			request.setAttribute("title", "Login");
			request.getRequestDispatcher("/WEB-INF/pages/admin/login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute(Constants.LOGGED_IN_PARAM, true);
			session.setAttribute(Constants.USER_PARAM, foundUser);
			String redirectionDestination = (String)session.getAttribute(Constants.PAGE_REDIRECTION);
			if (redirectionDestination == null) {
				redirectionDestination = "/WebGuideExam";
			}
			response.sendRedirect(redirectionDestination);
		}
		
	}
	
}
