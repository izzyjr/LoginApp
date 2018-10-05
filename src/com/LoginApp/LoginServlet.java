package com.LoginApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginApp.service.LoginService;
import com.LoginApp.service.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId, password;
		
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean results = loginService.authenticate(userId, password);
		
		if (results) {
			User user = loginService.getUserDetails(userId);
			HttpSession session  = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("success.jsp");
			return;
		}
		else {
			response.sendRedirect("login.jsp");
			return;
		}
		
	}

}
