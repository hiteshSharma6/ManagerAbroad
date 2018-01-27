package com.finessy.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finessy.web.user.UserDAO;

//@WebFilter({"/dashboard/*", "/forum/*"})
public class SessionFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter");
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		
		if(session == null) {
			Cookie[] cookies = null;
			
			cookies = ((HttpServletRequest) request).getCookies();
			
			if(cookies != null && cookies.length > 0) {
				UserDAO userDAO = new UserDAO();
				String email = null;
				String pass = null;
				
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					
					if(cookieName.contains("ma_enter_")) {
						if(cookieName.endsWith("em")) {
							email = cookie.getValue();
						}
						else if(cookieName.endsWith("ps")) {
							pass = cookie.getValue();
						}
						
					}
					
					if(email != null && pass != null) {
						try {
							if(userDAO.doExist(email, pass)) {
								chain.doFilter(request, response);
								return;
							}
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						
					}
				}
			}
			
			String requestURI = ((HttpServletRequest) request).getRequestURI();
			System.out.println("No session");
//			String url = ((HttpServletRequest) request).getRequestURI();
//			String start = "finessy/";
//			int url2 = url.indexOf(start) + start.length();
//			System.out.println(url2);
//			System.out.println(url.substring(url2));
//			String cp = ((HttpServletRequest)request).getContextPath();
//			System.out.println(cp);
//		    String encodedUrl = ((HttpServletResponse) response).encodeURL(cp + "/login.html");
//		    System.out.println(encodedUrl);
//			request.getRequestDispatcher("login").forward(request, response);
			((HttpServletResponse)response).sendRedirect("/managerAbroad/login.html");
			return;
		}
		else {
			System.out.println("out");
			chain.doFilter(request, response);
		}
		
	}

}
