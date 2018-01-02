package com.finessy.web.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finessy.web.util.AuthenticateUser;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("userid");
		String pass = request.getParameter("password");
		
		boolean valid = AuthenticateUser.valid(email, pass);
		if(valid) {
			boolean exist = AuthenticateUser.exist(email, pass);
			if(exist) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Email", email);
				response.sendRedirect("welcome.html");
				return;
			}
			else {
				response.sendRedirect("login.html");
			}
			
		}
		else {
			response.sendRedirect("welcome.html");
		}
		
	}

}
