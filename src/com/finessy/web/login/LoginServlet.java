package com.finessy.web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		
//		Cookie[] cookies = request.getCookies();
//		boolean cookieExist = false;
//		for(Cookie cookie : cookies) {
//			
//		}
//		
//		if(cookieExist) {
//			return;
//		}
		
		String email = request.getParameter("userid");
		String pass = request.getParameter("password");
		
		boolean valid = AuthenticateUser.valid(email, pass);
		if(valid) {
			boolean exist = AuthenticateUser.exist(email, pass);
			if(exist) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
//				request.getRequestDispatcher("welcome.html").forward(request, response);
				response.sendRedirect("dashboard.html");
			}
			else {
				response.sendRedirect("dashboard");
			}
			
		}
		else {
			response.sendRedirect("dashboard.html");
		}

				
	}

}
