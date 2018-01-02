package com.finessy.web.dashborad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println(session);
		if(session == null) {
			request.getRequestDispatcher("welcome.html").forward(request, response);;
			System.out.println("Going out");
			return;
		}
		System.out.println("out");
		request.getRequestDispatcher("dashboard.html").forward(request, response);;
		String data = (String) session.getAttribute("email");
		System.out.println(data);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null)
			System.out.println("VALID session");
		System.out.println("onnnnnnnnnnppppppppp");
		response.sendRedirect("login.html");
//		String data = (String) session.getAttribute("email");
//		System.out.println(data);
//		response.setContentType("text/plain");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(data);
		Cookie cookie = null;
		Cookie[] cookies = null;
		
		cookies = request.getCookies();
		
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
	            cookie = cookies[i];
	            System.out.println("Name : " + cookie.getName( ) + ",  ");
	            System.out.println("Value: " + cookie.getValue( ) + " <br/>");
	         }
		}
	}

}
